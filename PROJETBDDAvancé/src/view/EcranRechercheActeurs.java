package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllers.BoutonRechercheacteur;

public class EcranRechercheActeurs extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel tag;
	private JLabel tag1;
	private JLabel tag2;
	private JPanel milieu;
	private JTextArea nomact;
	private JTextArea prenomact;
	private JButton rechercher;
	private JTextArea resultat;
	private JScrollPane sp;  
	private JPanel contenuresultat;
	
	public EcranRechercheActeurs() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());
		
		tag=new JLabel ("Rechercher un acteur");
		tag.setFont(tag.getFont().deriveFont(Font.PLAIN, 19));
		
		tag1=new JLabel ("Nom : ");
		nomact=new JTextArea(1,15);
		tag2=new JLabel ("Prénom : ");
		prenomact=new JTextArea(1,15);
		rechercher= new JButton("Rechercher");
		resultat=new JTextArea(16,52);
		resultat.setEditable(false);
		
		sp= new JScrollPane(resultat);
		
		contenuresultat=new JPanel();
		contenuresultat.add(sp);
		milieu=new JPanel();
		milieu.add(tag1);
		milieu.add(nomact);
		milieu.add(tag2);
		milieu.add(prenomact);
		milieu.add(rechercher);
		
		add(tag,BorderLayout.NORTH);
		add(milieu,BorderLayout.CENTER);
		add(contenuresultat, BorderLayout.SOUTH);
		
		
		rechercher.addActionListener(new BoutonRechercheacteur(this));
	}

	public JTextArea getNomact() {
		return nomact;
	}

	public void setNomact(JTextArea nomact) {
		this.nomact = nomact;
	}

	public JTextArea getResultat() {
		return resultat;
	}

	public void setResultat(JTextArea resultat) {
		this.resultat = resultat;
	}

	public JTextArea getPrenomact() {
		return prenomact;
	}

	public void setPrenomact(JTextArea prenomact) {
		this.prenomact = prenomact;
	}

}
