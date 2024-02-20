package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.time.LocalDate;

import models.requeteBDD;
import view.AjouterFilms;

public class BoutonContinuer_ajouter implements ActionListener{
	AjouterFilms ecran;
	
	public BoutonContinuer_ajouter(AjouterFilms e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		requeteBDD a;
		if ((!ecran.getNomfilm().getText().equals(""))&&(!ecran.getAnnfilm().getText().equals(""))) {
			LocalDate current_date = LocalDate.now();
			if ((Integer.parseInt(ecran.getAnnfilm().getText())>1900)&&(Integer.parseInt(ecran.getAnnfilm().getText())<=current_date.getYear())) {
				try {
				a=new requeteBDD();
				if (!a.verif_filmexiste(ecran.getNomfilm().getText(),Integer.parseInt(ecran.getAnnfilm().getText()))){
					ecran.getF().setTitre(ecran.getNomfilm().getText());
					ecran.getFilm().setText("Nom du film : "+ecran.getF().getTitre());
					
					ecran.getF().setAnnee(Integer.parseInt(ecran.getAnnfilm().getText()));
					ecran.getResume().add(new JLabel("Année : "+ ecran.getAnnfilm().getText()));
					ecran.continuer();
				}
				else {
					JOptionPane.showMessageDialog(null,"Film existant");
				}
				}catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		}
			else {
				JOptionPane.showMessageDialog(null,"Entrez une date valide");
			}
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Remplissez les zones.");
		}
		
	}

}
