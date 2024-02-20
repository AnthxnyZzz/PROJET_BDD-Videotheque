package main;

import javax.swing.JFrame;

import view.Connexion;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fen= new JFrame();
		fen.setTitle("Connexion");
		fen.setSize(400,200);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setLocationRelativeTo(null);
		
		Connexion ed = new Connexion(fen);
		//fen.setIconImage(null);
		fen.getContentPane().add(ed);
		fen.setVisible(true);
	}

}
