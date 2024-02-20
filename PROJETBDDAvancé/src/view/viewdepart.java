package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers_BoutonPrincipaux.AjouterFilmController;
import controllers_BoutonPrincipaux.ChercherActeurs;
import controllers_BoutonPrincipaux.ChercherRealisateurs;
import controllers_BoutonPrincipaux.ModifierFilm;
import controllers_BoutonPrincipaux.Rechercherunfilm;
import controllers_BoutonPrincipaux.SupprimerFilms;

public class viewdepart extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel tag1;
	
	
	private JButton ajouterfilms;
	private JButton rechercherfilm;
	private JButton supprimerfilms;
	private JButton modifierfilms;
	private JButton chercheracteurs;
	private JButton chercherreal;


	private JPanel ChoixButton;
	private JPanel affichageprogramme;
	private JPanel programme;
	
	private JPanel recherfilm;
	
	private CardLayout cardLayout;
	
	
	
	public viewdepart() {
		super();
		this.setLayout(new BorderLayout());
		
		//Initialization
			tag1=new JLabel ("APPLICATION D'ACCÈS À LA BASE DE DONNÉES videotheque");
			tag1.setFont(tag1.getFont().deriveFont(Font.PLAIN, 19));
			tag1.setBackground(new Color(235, 204, 52));
			

			tag1.setHorizontalAlignment(JLabel.CENTER);
			add(tag1,BorderLayout.NORTH);
			
			rechercherfilm=new JButton("Rechercher un film");
			ajouterfilms= new JButton("Ajouter un film");
			supprimerfilms=new JButton("Supprimer un film");
			modifierfilms= new JButton("Modifier un film");
			chercheracteurs=new JButton("Chercher un acteur");
			chercherreal=new JButton("Chercher un réalisateur");
			
			ChoixButton=new JPanel();
			ChoixButton.setLayout(new GridLayout(3, 1));
			ChoixButton.add(rechercherfilm);
			ChoixButton.add(ajouterfilms);
			ChoixButton.add(supprimerfilms);
			ChoixButton.add(modifierfilms);
			ChoixButton.add(chercheracteurs);
			ChoixButton.add(chercherreal);

			add(ChoixButton,BorderLayout.WEST);
		
			
			cardLayout = new CardLayout();
			affichageprogramme= new JPanel(cardLayout);
			
			
			affichageprogramme.add(new JPanel(), "defaultPanel"); 
			affichageprogramme.add(new EcranRecherchefilm(), "rechercheFilm");
			affichageprogramme.add(new AjouterFilms(this), "ajouterfilms");
			affichageprogramme.add(new EcranSuppression(), "supprimerFilm");
			affichageprogramme.add(new EcranRechercheActeurs(),"chercheracteur");
			affichageprogramme.add(new EcranRechercheReal(),"chercherreal");
			affichageprogramme.add(new EcranModifierFilm(this),"modifierfilm");
			
			affichageprogramme.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			affichageprogramme.setBackground(new Color(235, 204, 52));


			add(affichageprogramme,BorderLayout.CENTER);
			
			recherfilm=new EcranRecherchefilm();
			
			


				//Association entre le bouton et son contrôleur
				rechercherfilm.addActionListener(new Rechercherunfilm(this));
				ajouterfilms.addActionListener(new AjouterFilmController(this));
				supprimerfilms.addActionListener(new SupprimerFilms(this));
				chercheracteurs.addActionListener(new ChercherActeurs(this));
				chercherreal.addActionListener(new ChercherRealisateurs(this));
				modifierfilms.addActionListener(new ModifierFilm(this));
				
	}

	public void resetAjoutFilm() {
		affichageprogramme.add(new AjouterFilms(this), "ajouterfilms");
		CardLayout cardLayout = (CardLayout) getAffichageprogramme().getLayout();
        cardLayout.show(getAffichageprogramme(), "ajouterfilms");
		revalidate();
		repaint();
		
	}
	public void resetModifFilm() {
		affichageprogramme.add(new EcranModifierFilm(this), "modifierfilm");
		CardLayout cardLayout = (CardLayout) getAffichageprogramme().getLayout();
        cardLayout.show(getAffichageprogramme(), "modifierfilm");
		revalidate();
		repaint();
		
	}

	public JPanel getAffichageprogramme() {
		return affichageprogramme;
	}



	public void setAffichageprogramme(JPanel affichageprogramme) {
		this.affichageprogramme = affichageprogramme;
	}



	public JPanel getRecherfilm() {
		return recherfilm;
	}



	public void setRecherfilm(JPanel recherfilm) {
		this.recherfilm = recherfilm;
	}



	public JPanel getProgramme() {
		return programme;
	}



	public void setProgramme(JPanel prog) {
		this.programme = prog;
	}
	public void resetProgramme() {
		this.programme=new JPanel();
	}



	

}
