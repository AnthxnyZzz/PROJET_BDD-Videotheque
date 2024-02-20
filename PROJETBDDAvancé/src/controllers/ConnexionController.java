package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.pageaccueil;
import models.requeteBDD;
import view.Connexion;

public class ConnexionController implements ActionListener {
	Connexion EcranConnexion;
	
	public ConnexionController(Connexion e) {
		EcranConnexion=e;
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		if ((!EcranConnexion.getUser().getText().equals(""))&&(!new String(EcranConnexion.getMdp().getPassword()).equals(""))) {
			requeteBDD a;
			try {
				a = new requeteBDD();
				if(a.utilisateur_existe(EcranConnexion.getUser().getText(), new String(EcranConnexion.getMdp().getPassword()))) {
					//Mise à jour de la vue
					EcranConnexion.getResultat().setText("Connexion établie.");
					EcranConnexion.fermer();
					pageaccueil.main(null);
					
					
					}
					
					
				
				else {
					JOptionPane.showMessageDialog(null,"Utilisateur inconnu");
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Remplissez les deux zones.");
		}
		
	}

}
