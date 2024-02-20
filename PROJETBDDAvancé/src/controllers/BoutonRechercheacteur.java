package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.requeteBDD;
import view.EcranRechercheActeurs;

public class BoutonRechercheacteur implements ActionListener{
	EcranRechercheActeurs ecran;
	
	public BoutonRechercheacteur(EcranRechercheActeurs e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		requeteBDD a;
		ArrayList<String> acteurs;
		try {
			a=new requeteBDD();
			acteurs=a.rechercheacteur(ecran.getNomact().getText(),ecran.getPrenomact().getText());
			ecran.getResultat().setText(acteurs.size()+" acteurs(s) trouvé(s) : \n");
			for (String u:acteurs) {
				ecran.getResultat().setText(ecran.getResultat().getText()+ u + "\n");
				
			}
			ecran.getResultat().setCaretPosition(0);
			
			}catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	
		
	}

}
