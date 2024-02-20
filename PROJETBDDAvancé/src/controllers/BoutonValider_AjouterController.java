package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.acteurs;
import models.requeteBDD;
import view.AjouterFilms;
import view.champActeur;

public class BoutonValider_AjouterController implements ActionListener{
	AjouterFilms ecran;
	public BoutonValider_AjouterController(AjouterFilms e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		requeteBDD a;
		ArrayList<acteurs> listeacteur=new ArrayList<acteurs>();
		int taille= ecran.getListeacteurs().size();
		boolean estnombre=false;
		try {
			@SuppressWarnings("unused")
			int r= Integer.parseInt(ecran.getListeacteurs().get(taille-1).avoirlerang());
			estnombre=true;
		}catch (NumberFormatException y) {
			estnombre=false;
		}
		
		if ((ecran.getListeacteurs().get(taille-1).avoirlenom().equals(""))||(ecran.getListeacteurs().get(taille-1).avoirleprenom().equals(""))||(ecran.getListeacteurs().get(taille-1).avoirlerang().equals(""))||(!estnombre)) {
			ecran.getListeacteurs().remove(taille-1);
		}
		
		try {
			a=new requeteBDD();
			if (ecran.getF().getIdrealisateur()==0) {
				ecran.getF().setIdrealisateur(a.creaReal(ecran.getNomreal().getText(), ecran.getPrenomreal().getText()));
			}
			
			for (champActeur u:ecran.getListeacteurs()) {
				
				if (a.acteurexiste(u.avoirlenom(),u.avoirleprenom())==0) {
					listeacteur.add(new acteurs(u.avoirlenom(),u.avoirleprenom(),a.creaActeur(u.avoirlenom(),u.avoirleprenom()),Integer.parseInt(u.avoirlerang())));
				}
				else {
					listeacteur.add(new acteurs(u.avoirlenom(),u.avoirleprenom(),a.acteurexiste(u.avoirlenom(),u.avoirleprenom()),Integer.parseInt(u.avoirlerang())));
				}
			}
			ecran.getF().setId(a.creafilm(ecran.getF()));
			
			for (acteurs u:listeacteur) {
				a.jouer(ecran.getF(), u);
			}
			JOptionPane.showMessageDialog(null,"Ajout réussi.\nid: "+ecran.getF().getId()+" titre: "+ecran.getF().getTitre()+"\nannee: "+ecran.getF().getAnnee()+"\nScore: "+ecran.getF().getScore());
			ecran.getBase().resetAjoutFilm();
			
			
		}catch (Exception e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Échec de l'ajout.");
			e2.printStackTrace();
		}
		
		
	}

}
