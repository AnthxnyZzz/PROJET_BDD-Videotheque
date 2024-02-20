package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class champActeur extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel acteurPanel;
	private JLabel saisienomacteur;
	private JTextField nomacteur;
	private JLabel saisieprenomacteur;
	private JTextField prenomacteur;
	private JLabel saisierangacteur;
	private JTextField rang;
	
	public champActeur() {
		super();
		// TODO Auto-generated constructor stub
		acteurPanel = new JPanel();
        acteurPanel.setLayout(new FlowLayout());

        saisienomacteur = new JLabel("Nom acteur:");
        nomacteur = new JTextField();
        nomacteur.setPreferredSize(new Dimension(115,20));
        

        saisieprenomacteur = new JLabel("Prénom acteur:");
        prenomacteur = new JTextField();
        prenomacteur.setPreferredSize(new Dimension(115,20));
        
        saisierangacteur=new JLabel("Rang acteur : ");
        rang=new JTextField();
        rang.setPreferredSize(new Dimension(50,20));

        acteurPanel.add(saisienomacteur);
        acteurPanel.add(nomacteur);
        acteurPanel.add(saisieprenomacteur);
        acteurPanel.add(prenomacteur);
        acteurPanel.add(saisierangacteur);
        acteurPanel.add(rang);
        
        add(acteurPanel);
	}

	public JPanel getActeurPanel() {
		return acteurPanel;
	}

	public void setActeurPanel(JPanel acteurPanel) {
		this.acteurPanel = acteurPanel;
	}

	public JTextField getNomacteur() {
		return nomacteur;
	}

	public void setNomacteur(JTextField nomacteur) {
		this.nomacteur = nomacteur;
	}

	public JTextField getPrenomacteur() {
		return prenomacteur;
	}

	public void setPrenomacteur(JTextField prenomacteur) {
		this.prenomacteur = prenomacteur;
	}

	public JTextField getRang() {
		return rang;
	}

	public void setRang(JTextField rang) {
		this.rang = rang;
	}
	
	public String avoirlenom() {
		return nomacteur.getText();
	}
	
	public String avoirleprenom() {
		return prenomacteur.getText();
	}
	public String avoirlerang() {
		return rang.getText();
	}
	
}
