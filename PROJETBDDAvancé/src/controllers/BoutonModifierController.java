package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.requeteBDD;
import view.EcranModifierFilm;

public class BoutonModifierController implements ActionListener{
	EcranModifierFilm ecran;
	public BoutonModifierController(EcranModifierFilm e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		requeteBDD a;
		String nom;
		if(!ecran.getIdfilm().getText().equals("")) {
			try {
				a=new requeteBDD();
				nom=a.selectionfilm(Integer.parseInt(ecran.getIdfilm().getText()));
				
				if (!nom.equals("")) {
					ecran.getNomaffiche().setText(nom);
					ecran.continuer();
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Film inexistant");
				}
				
				
				}catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		}
		else {
			JOptionPane.showMessageDialog(null,"Remplissez la zone.");
		}
		
	}

}
