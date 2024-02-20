package models;

public class acteurs {
	private String nom;
	private String prenom;
	private int id;
	private int rang;
	

	public acteurs(String n,String pre,int i,int r) {
		nom=n;
		prenom=pre;
		id=i;
		rang=r;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
		
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRang() {
		return rang;
	}


	public void setRang(int rang) {
		this.rang = rang;
	}
	
	
	
}
