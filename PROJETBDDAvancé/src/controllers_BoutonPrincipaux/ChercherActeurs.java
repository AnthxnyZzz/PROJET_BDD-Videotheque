package controllers_BoutonPrincipaux;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewdepart;

public class ChercherActeurs implements ActionListener {
	viewdepart ecran;
	
	public ChercherActeurs(viewdepart e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cardLayout = (CardLayout) ecran.getAffichageprogramme().getLayout();
        cardLayout.show(ecran.getAffichageprogramme(), "chercheracteur");
	}
}
