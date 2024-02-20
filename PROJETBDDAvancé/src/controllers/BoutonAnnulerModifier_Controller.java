package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EcranModifierFilm;

public class BoutonAnnulerModifier_Controller implements ActionListener{
	EcranModifierFilm ecran;
	public BoutonAnnulerModifier_Controller(EcranModifierFilm e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ecran.getBase().resetModifFilm();
	}

}
