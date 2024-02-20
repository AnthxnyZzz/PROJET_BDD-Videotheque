package models;


public class realisateurs {
	private String nom;
	private String prenom;
	private int id;
	

	public realisateurs(String n,String pre,int i) {
		id=i;
		prenom=pre;
		nom=n;
	}
	
	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
}







		 
		
		
