package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.BoutonAnnuler_Controller;
import controllers.BoutonContinuer2_ajouter;
import controllers.BoutonContinuer3_ajouter;
import controllers.BoutonContinuer_ajouter;
import controllers.BoutonValider_AjouterController;
import controllers.ajouterActeursChampController;
import models.films;

public class AjouterFilms extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private films f=new films("");

		private JLabel tag;
		private JLabel saisienomfilm;
		private JPanel milieu;
		private JTextField nomfilm;
		private JButton continuer;
		private JButton continuer2;
		private JButton continuer3;
		
		private JPanel annee;
		private JLabel saisieann;
		private JTextField annfilm;
		
		private JLabel saisienomreal;
		private JLabel saisieprenomreal;
		private JTextField nomreal;
		private JTextField prenomreal;
		
		private JButton ajouteracteur;
		ArrayList<champActeur> Listeacteurs;
		
		private JPanel filmactu;
		private JLabel film;
		private JPanel resume;
		
		private JLabel saisiescore;
		private JTextField score;
		private JLabel saisienbvotant;
		private JTextField nbvotant;
		
		
		private JPanel bas;
		private JButton annuler;
		private JButton finir;
		
		private viewdepart base;
		
		
	
	public AjouterFilms(viewdepart e) {
		// TODO Auto-generated constructor stub
		
		//Initialization
		super();
		base=e;
		this.setLayout(new BorderLayout());
		
		tag=new JLabel ("Ajouter un film");
		tag.setFont(tag.getFont().deriveFont(Font.PLAIN, 19));
		
		saisienomfilm=new JLabel("Nom du film :");
		nomfilm=new JTextField();
		nomfilm.setPreferredSize(new Dimension(115,20));
		
		saisieann=new JLabel("Année : ");
		annfilm= new JTextField();
		annfilm.setPreferredSize(new Dimension(40,25));
		
		annee=new JPanel();
		annee.add(saisieann);
		annee.add(annfilm);
		
		continuer= new JButton("Continuer");
		continuer2= new JButton("Continuer");
		continuer3=new JButton("Continuer");
		
		saisienomreal=new JLabel("Nom du réalisateur");
		nomreal=new JTextField();
		nomreal.setPreferredSize(new Dimension(115,20));
		saisieprenomreal=new JLabel("Prénom du réalisateur");
		prenomreal=new JTextField();
		prenomreal.setPreferredSize(new Dimension(115,20));
		
		
		saisiescore=new JLabel("Score : ");
		score=new JTextField();
		score.setPreferredSize(new Dimension(60,25));
		saisienbvotant=new JLabel("Nombre de votant : ");
		nbvotant=new JTextField();
		nbvotant.setPreferredSize(new Dimension(60,25));
		
		
		Listeacteurs=new ArrayList<>();
		
		
		annuler= new JButton("Annuler");
		finir=new JButton("Valider");
		finir.setEnabled(false);
		bas=new JPanel();
		bas.add(annuler);
		bas.add(finir);
		
		filmactu=new JPanel();
		film=new JLabel("");
		resume=new JPanel();
		
		filmactu.add(film);
		filmactu.add(resume);
		filmactu.setLayout(new BoxLayout(filmactu, BoxLayout.Y_AXIS));
		filmactu.setPreferredSize(new Dimension(300,45));
		filmactu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		ajouteracteur = new JButton("Ajouter Acteur");
		
		
		milieu=new JPanel();
		milieu.add(saisienomfilm);
		milieu.add(nomfilm);
		milieu.add(annee);
		milieu.add(continuer);
		
		add(tag,BorderLayout.NORTH);
		add(milieu,BorderLayout.CENTER);
		add(filmactu, BorderLayout.EAST);
		
		continuer.addActionListener(new BoutonContinuer_ajouter(this));
		continuer2.addActionListener(new BoutonContinuer2_ajouter(this));
		continuer3.addActionListener(new BoutonContinuer3_ajouter(this));
		ajouteracteur.addActionListener(new ajouterActeursChampController(this));
		annuler.addActionListener(new BoutonAnnuler_Controller(this));
		finir.addActionListener(new BoutonValider_AjouterController(this));
	}
	
	public void continuer() {
		milieu.remove(saisienomfilm);
		milieu.remove(nomfilm);
		milieu.remove(annee);
		milieu.remove(continuer);
		
		
		milieu.add(saisienomreal);
		milieu.add(nomreal);
		milieu.add(saisieprenomreal);
		milieu.add(prenomreal);
		milieu.add(continuer2);
		this.add(bas,BorderLayout.SOUTH);
		
		
		revalidate();
        repaint();
	}
	public void continuer2() {
		milieu.remove(saisienomreal);
		milieu.remove(nomreal);
		milieu.remove(saisieprenomreal);
		milieu.remove(prenomreal);
		milieu.remove(continuer2);
		
		milieu.add(saisiescore);
		milieu.add(score);
		milieu.add(saisienbvotant);
		milieu.add(nbvotant);
		milieu.add(continuer3);
		revalidate();
        repaint();
	}
	
	public void continuer3() {
		milieu.remove(saisiescore);
		milieu.remove(score);
		milieu.remove(saisienbvotant);
		milieu.remove(nbvotant);
		milieu.remove(continuer3);
		
		milieu.add(ajouteracteur);
		revalidate();
        repaint();
	}
	
	public void ajouterunchampacteur() {
		// Création d'un nouveau panneau pour l'acteur
		if (!finir.isEnabled()) {
			finir.setEnabled(true);
		}
        
		
		champActeur acteur= new champActeur();
		
		Listeacteurs.add(acteur);
		milieu.add(acteur);
		
        // Redessiner la fenêtre
        revalidate();
        repaint();
	}
	
	
	public JTextField getNomfilm() {
		return nomfilm;
	}

	public void setNomfilm(JTextField nomfilm) {
		this.nomfilm = nomfilm;
	}

	public JTextField getAnnfilm() {
		return annfilm;
	}

	public void setAnnfilm(JTextField annfilm) {
		this.annfilm = annfilm;
	}
	public films getF() {
		return f;
	}

	public void setF(films f) {
		this.f = f;
	}

	public JLabel getFilm() {
		return film;
	}

	public void setFilm(JLabel film) {
		this.film = film;
	}

	public JPanel getResume() {
		return resume;
	}

	public void setResume(JPanel resume) {
		this.resume = resume;
	}

	public JTextField getNomreal() {
		return nomreal;
	}

	public void setNomreal(JTextField nomreal) {
		this.nomreal = nomreal;
	}

	public JTextField getPrenomreal() {
		return prenomreal;
	}

	public void setPrenomreal(JTextField prenomreal) {
		this.prenomreal = prenomreal;
	}

	public viewdepart getBase() {
		return base;
	}

	public void setBase(viewdepart base) {
		this.base = base;
	}

	public ArrayList<champActeur> getListeacteurs() {
		return Listeacteurs;
	}

	public void setListeacteurs(ArrayList<champActeur> listeacteurs) {
		Listeacteurs = listeacteurs;
	}

	public JTextField getScore() {
		return score;
	}

	public void setScore(JTextField score) {
		this.score = score;
	}

	public JTextField getNbvotant() {
		return nbvotant;
	}

	public void setNbvotant(JTextField nbvotant) {
		this.nbvotant = nbvotant;
	}
	
	
	
	
}
