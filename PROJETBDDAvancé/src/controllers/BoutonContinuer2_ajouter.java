package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.requeteBDD;
import view.AjouterFilms;

public class BoutonContinuer2_ajouter implements ActionListener {
	AjouterFilms ecran;
	public BoutonContinuer2_ajouter(AjouterFilms e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		requeteBDD a;
		if ((!ecran.getNomreal().getText().equals(""))&&(!ecran.getPrenomreal().getText().equals(""))) {
			try {
				a=new requeteBDD();
				if (a.realisateurexiste(ecran.getNomreal().getText(), ecran.getPrenomreal().getText())!=0) {
					ecran.getF().setIdrealisateur(a.realisateurexiste(ecran.getNomreal().getText(), ecran.getPrenomreal().getText()));
				}
				else {
					ecran.getF().setIdrealisateur(0);
				}
				
				ecran.getResume().add(new JLabel("Réalisateur : "+ecran.getNomreal().getText()+ " " +ecran.getPrenomreal().getText() ));
				ecran.continuer2();
				
			}catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Remplissez les zones.");
		}
		
	}

}
