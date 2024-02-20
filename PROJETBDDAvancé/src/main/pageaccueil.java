package main;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import view.viewdepart;


public class pageaccueil {

	public pageaccueil() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fen1= new JFrame();
		fen1.setTitle("FlexFlix  | anthoo - Grâce - John ");
		fen1.setSize(910,600);
		fen1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		/*------------------------*/
			/*Icône de l'appli*/
			URL imageURL = Main.class.getResource("/image/icon.png");
	        ImageIcon icon = new ImageIcon(imageURL);
	        
	        Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(image);
	
	        fen1.setIconImage(resizedIcon.getImage());
		/*------------------------*/
		
	        
		fen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen1.setLocationRelativeTo(null);
		
		
		
		viewdepart ed = new viewdepart();
		
		
        
		fen1.getContentPane().add(ed);
		fen1.setVisible(true);
	}

}
