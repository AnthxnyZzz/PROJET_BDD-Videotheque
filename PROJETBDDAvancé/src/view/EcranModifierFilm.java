package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.BoutonAnnulerModifier_Controller;
import controllers.BoutonModifierController;

public class EcranModifierFilm extends JPanel{
private static final long serialVersionUID = 1L;
	
	viewdepart base;

	private JLabel tag;
	private JLabel tag1;
	private JPanel milieu;
	private JTextField idfilm;
	
	private JButton modifier;
	
	private JLabel nomaffiche;
	private JButton titre;
	private JButton annee;
	private JButton score;
	private JButton nbvotant;
	private JButton realisateurs;
	private JButton acteurs;
	
	private JButton annuler;
	
	public EcranModifierFilm(viewdepart e) {
		// TODO Auto-generated constructor stub
		super();
		base=e;
		this.setLayout(new BorderLayout());
		
		tag=new JLabel ("Modifier un film");
		tag.setFont(tag.getFont().deriveFont(Font.PLAIN, 19));
		
		tag1= new JLabel("ID du film : ");
		idfilm=new JTextField();
		idfilm.setPreferredSize(new Dimension(30,25));
		
		nomaffiche=new JLabel("");
		
		modifier=new JButton("Modifier");
		
		milieu=new JPanel();
		milieu.add(tag1);
		milieu.add(idfilm);
		milieu.add(modifier);
		
		annuler= new JButton("Annuler");
		
		add(tag,BorderLayout.NORTH);
		add(milieu,BorderLayout.CENTER);
		
		modifier.addActionListener(new BoutonModifierController(this));
		annuler.addActionListener(new BoutonAnnulerModifier_Controller(this));
	}

	public JTextField getIdfilm() {
		return idfilm;
	}

	public void setIdfilm(JTextField idfilm) {
		this.idfilm = idfilm;
	}
	
	public void continuer() {
		milieu.removeAll();
		milieu.setLayout(new BoxLayout(milieu, BoxLayout.Y_AXIS));
		
		titre=new JButton("Titre");
		annee=new JButton("Annee");
		score=new JButton("Score");
		nbvotant=new JButton("Nombre de votant");
		realisateurs=new JButton("Realisateurs");
		acteurs=new JButton("Acteurs");
		
		milieu.add(nomaffiche);
		
		milieu.add(titre);
		
		milieu.add(annee);
		milieu.add(score);
		milieu.add(nbvotant);
		milieu.add(realisateurs);
		milieu.add(acteurs);
		this.add(annuler,BorderLayout.SOUTH);
		
		revalidate();
        repaint();
		
	}

	public viewdepart getBase() {
		return base;
	}

	public void setBase(viewdepart base) {
		this.base = base;
	}

	public JLabel getNomaffiche() {
		return nomaffiche;
	}

	public void setNomaffiche(JLabel nomaffiche) {
		this.nomaffiche = nomaffiche;
	}
	
	
}
