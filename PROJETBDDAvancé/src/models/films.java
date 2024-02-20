package models;

public class films {
	private int id;
	private String titre;
	private int annee;
	private float score;
	private int nbvotant;
	private int idrealisateur;
	
	public films(int idd,String nom, int ann,int idreal) {
		id= idd;
		titre= nom;
		annee= ann;
		idrealisateur= idreal;
		
	}
	public films(String nom) {
		titre= nom;
		
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getNbvotant() {
		return nbvotant;
	}
	public void setNbvotant(int nbvotant) {
		this.nbvotant = nbvotant;
	}
	public int getIdrealisateur() {
		return idrealisateur;
	}
	public void setIdrealisateur(int idrealisateur) {
		this.idrealisateur = idrealisateur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}