package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.requeteBDD;
import view.EcranSuppression;

public class BoutonSupprimerController implements ActionListener{
	EcranSuppression ecran;
	
	public BoutonSupprimerController(EcranSuppression e) {
		// TODO Auto-generated constructor stub
		this.ecran=e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		requeteBDD a;
		String nom;
		if(!ecran.getIdfilm().getText().equals("")) {
			try {
				a=new requeteBDD();
				nom=a.selectionfilm(Integer.parseInt(ecran.getIdfilm().getText()));
				
				if (!nom.equals("")) {
					
					int res = JOptionPane.showConfirmDialog(null,"Etes-vous sur de supprimer "+nom+" ?");
				    
				    if(res == JOptionPane.YES_OPTION)
				    {
				    	if (a.supprimerfilms(Integer.parseInt(ecran.getIdfilm().getText()))) {
				    		JOptionPane.showMessageDialog(null,"Suppression réussi ! ");
				    	}
				    	else {
				    		JOptionPane.showMessageDialog(null,"La suppression a rencontré un soucis ! ");
				    	}
				      
				    }
				}
				else {
					JOptionPane.showMessageDialog(null,"Film inexistant");
				}
				
				
				}catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		}
		else {
			JOptionPane.showMessageDialog(null,"Remplissez la zone.");
		}
		
	}

}
