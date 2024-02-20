package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.BoutonSupprimerController;

public class EcranSuppression extends JPanel {
private static final long serialVersionUID = 1L;
	
	private JLabel tag;
	private JLabel tag1;
	private JPanel milieu;
	private JTextField idfilm;
	

	private JButton supprimer;
	
	public EcranSuppression() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());
		
		tag=new JLabel ("Supprimer un film");
		tag.setFont(tag.getFont().deriveFont(Font.PLAIN, 19));
		
		tag1= new JLabel("ID du film : ");
		idfilm=new JTextField();
		idfilm.setPreferredSize(new Dimension(30,25));
		
		supprimer=new JButton("Supprimer");
		
		milieu=new JPanel();
		milieu.add(tag1);
		milieu.add(idfilm);
		milieu.add(supprimer);
		
		add(tag,BorderLayout.NORTH);
		add(milieu,BorderLayout.CENTER);
		
		supprimer.addActionListener(new BoutonSupprimerController(this));
	}

	
	public JTextField getIdfilm() {
		return idfilm;
	}

	public void setIdfilm(JTextField idfilm) {
		this.idfilm = idfilm;
	}
}
