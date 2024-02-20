package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.ConnexionController;

public class Connexion extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel tag1;
	private JPanel princip;
	private JPanel con;
	private JPanel userpanel;
	private JPanel mdppanel;
	private JPanel bas;
	private JLabel tag2;
	private JLabel tag3;
	private JTextField user;
	private JPasswordField mdp;
	private JButton btValider;
	private JLabel resultat;
	JFrame fenetre;
	
	public Connexion(JFrame fen) {
		// TODO Auto-generated constructor stub
		super();
		
		fenetre=fen;
		
		
		
		//Initialization
			princip= new JPanel();
			princip.setLayout(new BorderLayout());
			tag1=new JLabel ("Connexion à la base de données");
			tag1.setFont(tag1.getFont().deriveFont(Font.PLAIN, 19));
			con= new JPanel();
			con.setLayout(new BorderLayout());
			
			userpanel=new JPanel();
			userpanel.setLayout(new BorderLayout());
			mdppanel=new JPanel();
			mdppanel.setLayout(new BorderLayout());
			
			tag2= new JLabel(": Nom d'utilisateur");
			user= new JTextField();
			user.setPreferredSize(new Dimension(115,20));
			tag3=new JLabel(": Mot de passe");
			mdp= new JPasswordField(null,10);
			mdp.setEchoChar('*');
			btValider=new JButton("Connexion");
			resultat=new JLabel("");
			
			bas= new JPanel();
			bas.setLayout(new BorderLayout());
			
				
				//Ajout au panel
				userpanel.add(tag2,BorderLayout.EAST);
				userpanel.add(user,BorderLayout.WEST);
				
				mdppanel.add(tag3,BorderLayout.EAST);
				mdppanel.add(mdp,BorderLayout.WEST);
				
				con.add(userpanel,BorderLayout.NORTH);
				con.add(mdppanel,BorderLayout.SOUTH);
				
				bas.add(btValider,BorderLayout.NORTH);
				bas.add(resultat,BorderLayout.SOUTH);
				
				princip.add(tag1,BorderLayout.NORTH);
				princip.add(con,BorderLayout.CENTER);
				princip.add(bas,BorderLayout.SOUTH);
				
				btValider.addActionListener(new ConnexionController(this));
				
				
				add(princip);
				
	}
	
	public void fermer() throws Exception {
		Thread.sleep(1000);
		fenetre.dispose();
	}
	
	public void enavant() {
		fenetre.toFront();
	}
	
	public JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JPasswordField getMdp() {
		return mdp;
	}

	public void setMdp(JPasswordField mdp) {
		this.mdp = mdp;
	}

	public JLabel getResultat() {
		return resultat;
	}

	public void setResultat(JLabel resultat) {
		this.resultat = resultat;
	}


}
