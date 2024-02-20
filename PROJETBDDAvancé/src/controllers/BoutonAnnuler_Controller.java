package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AjouterFilms;

public class BoutonAnnuler_Controller implements ActionListener{
	AjouterFilms ecran;
	public BoutonAnnuler_Controller(AjouterFilms e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ecran.getBase().resetAjoutFilm();
		
	}

}
