package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.AjouterFilms;

public class BoutonContinuer3_ajouter implements ActionListener{
	AjouterFilms ecran;
	public BoutonContinuer3_ajouter(AjouterFilms e) {
		// TODO Auto-generated constructor stub
		ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((!ecran.getScore().getText().equals(""))&&(!ecran.getNbvotant().getText().equals(""))) {
			try {
				float u=Float.parseFloat(ecran.getScore().getText());
				int v= Integer.parseInt(ecran.getNbvotant().getText());
				ecran.getF().setScore(u);
				ecran.getF().setNbvotant(v);
				ecran.getResume().add(new JLabel("Score : "+u + " Nombre de votants:" +v ));
				ecran.continuer3();
				
			}catch (Exception e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Les valeurs entrées sont invalides.");
			}
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Remplissez les zones.");
		}
	}

}
