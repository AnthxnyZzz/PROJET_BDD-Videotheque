package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.requeteBDD;
import view.EcranRechercheReal;

public class BoutonRecherchereal implements ActionListener {
	EcranRechercheReal ecran;
	public BoutonRecherchereal(EcranRechercheReal e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		requeteBDD a;
		ArrayList<String> realisateurs;
		try {
			a=new requeteBDD();
			realisateurs=a.recherchereal(ecran.getNomreal().getText(),ecran.getPrenomreal().getText());
			ecran.getResultat().setText(realisateurs.size()+" réalisateur(s) trouvé(s) : \n");
			for (String u:realisateurs) {
				ecran.getResultat().setText(ecran.getResultat().getText()+ u + "\n");
				
			}
			ecran.getResultat().setCaretPosition(0);
			
			}catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	
		
	}
}
