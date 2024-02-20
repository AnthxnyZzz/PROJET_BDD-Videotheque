package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllers.BoutonRechercherfilm;

public class EcranRecherchefilm extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel tag;
	private JPanel milieu;
	private JTextArea nomfilm;
	private JButton rechercher;
	private JTextArea resultat;
	private JScrollPane sp;  
	private JPanel contenuresultat;
	
	
	public EcranRecherchefilm() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());
		
		tag=new JLabel ("Rechercher un film");
		tag.setFont(tag.getFont().deriveFont(Font.PLAIN, 19));
		
		nomfilm=new JTextArea(1,15);
		rechercher= new JButton("Rechercher");
		resultat=new JTextArea(16,52);
		resultat.setEditable(false);
		
		sp= new JScrollPane(resultat);
		
		contenuresultat=new JPanel();
		contenuresultat.add(sp);
		
		
		
		milieu=new JPanel();
		milieu.add(nomfilm);
		milieu.add(rechercher);
		
		add(tag,BorderLayout.NORTH);
		add(milieu,BorderLayout.CENTER);
		add(contenuresultat, BorderLayout.SOUTH);
		
		
		rechercher.addActionListener(new BoutonRechercherfilm(this));
	}


	public JTextArea getNomfilm() {
		return nomfilm;
	}


	public void setNomfilm(JTextArea nomfilm) {
		this.nomfilm = nomfilm;
	}


	public JTextArea getResultat() {
		return resultat;
	}


	public void setResultat(JTextArea resultat) {
		this.resultat = resultat;
	}
	
	
	

}
