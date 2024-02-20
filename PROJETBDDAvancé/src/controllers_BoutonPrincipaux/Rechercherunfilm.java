package controllers_BoutonPrincipaux;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewdepart;

public class Rechercherunfilm implements ActionListener{
	viewdepart ecran;
	
	public Rechercherunfilm(viewdepart e) {
		// TODO Auto-generated constructor stub
		this.ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cardLayout = (CardLayout) ecran.getAffichageprogramme().getLayout();
        cardLayout.show(ecran.getAffichageprogramme(), "rechercheFilm");
	}

}
