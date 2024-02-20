package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.requeteBDD;
import view.EcranRecherchefilm;

public class BoutonRechercherfilm implements ActionListener{
	EcranRecherchefilm ecran;
	
	public BoutonRechercherfilm(EcranRecherchefilm e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		requeteBDD a;
		ArrayList<String> films;
		
		try {
			a=new requeteBDD();
			films=a.recherchefilm(ecran.getNomfilm().getText());
			ecran.getResultat().setText(films.size()+" film(s) trouvé(s) : \n");
			for (String u:films) {
				ecran.getResultat().setText(ecran.getResultat().getText()+ u + "\n");
				
			}
			ecran.getResultat().setCaretPosition(0);
			
			}catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		
		
	}

}
