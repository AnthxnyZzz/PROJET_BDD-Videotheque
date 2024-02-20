package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.AjouterFilms;

public class ajouterActeursChampController implements ActionListener{
	AjouterFilms ecran;
	
	public ajouterActeursChampController(AjouterFilms e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		int taille= ecran.getListeacteurs().size();
		if (taille>=1) {
			boolean estnombre=false;
			try {
				@SuppressWarnings("unused")
				int r= Integer.parseInt(ecran.getListeacteurs().get(taille-1).avoirlerang());
				estnombre=true;
			}catch (NumberFormatException y) {
				estnombre=false;
			}
			
			if ((!ecran.getListeacteurs().get(taille-1).avoirlenom().equals(""))&&(!ecran.getListeacteurs().get(taille-1).avoirleprenom().equals(""))&&(!ecran.getListeacteurs().get(taille-1).avoirlerang().equals(""))&&(estnombre)) {
				if (Integer.parseInt(ecran.getListeacteurs().get(taille-1).avoirlerang())>0) {
					ecran.getListeacteurs().get(taille-1).getNomacteur().setEditable(false);
				ecran.getListeacteurs().get(taille-1).getPrenomacteur().setEditable(false);
				ecran.getListeacteurs().get(taille-1).getRang().setEditable(false);
				ecran.getResume().add(new JLabel(ecran.getListeacteurs().get(taille-1).avoirlenom()+" "+ecran.getListeacteurs().get(taille-1).avoirleprenom() + "  rang:" +ecran.getListeacteurs().get(taille-1).avoirlerang() ));
				ecran.ajouterunchampacteur();
				}
				else {
					JOptionPane.showMessageDialog(null,"Le rang n'est pas correct");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null,"Remplissez toutes les entrées avant d'ajouter un autre");
			}
		        
		}
		else {
			ecran.getResume().add(new JLabel("Les acteurs :"));
			ecran.ajouterunchampacteur();
		}
		
    }
}
