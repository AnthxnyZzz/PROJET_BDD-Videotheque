package controllers_BoutonPrincipaux;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewdepart;

public class SupprimerFilms implements ActionListener{
	viewdepart ecran;
	public SupprimerFilms(viewdepart e) {
		// TODO Auto-generated constructor stub
		this.ecran=e;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout) ecran.getAffichageprogramme().getLayout();
        cardLayout.show(ecran.getAffichageprogramme(), "supprimerFilm");
	}
	
	

}
