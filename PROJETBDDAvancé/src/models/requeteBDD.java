package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class requeteBDD {
	private String urlBD = "jdbc:sqlserver://localhost;databaseName=videotheque;integratedSecurity=true;encrypt=false";
	private Connection con;
	
	
	public requeteBDD() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(urlBD);
	}
	
	public Boolean utilisateur_existe(String user,String mdp) throws Exception {
		String req="SELECT login,mdp FROM [videotheque].[dbo].[user] WHERE login='"+user+"'AND mdp='"+mdp+"';";
		Statement stmt = con.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		
		if (rslt.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ArrayList<String> recherchefilm(String nomfilm) throws Exception {
		 String req = "SELECT films.id,titre, annee, realisateurs.nom ,realisateurs.prenom, score,nbvotant FROM [videotheque].[dbo].[films] JOIN realisateurs ON films.idrealisateur=realisateurs.id WHERE titre LIKE '%" + nomfilm + "%';";
	     Statement stmt = con.createStatement();
	     ResultSet rslt = stmt.executeQuery(req);

	     ArrayList<String> films = new ArrayList<String>();
	        while (rslt.next()) {
	        	int id= rslt.getInt("id");
	            String titre = rslt.getString("titre");
	            int annee= rslt.getInt("annee");
	            String nomreal=rslt.getString("nom");
	            String prenomreal=rslt.getString("prenom");
	            float score=rslt.getFloat("score");
	            int nbvotant=rslt.getInt("nbvotant");
	            
	            String act="Acteurs du films: \n";
	            String req2="SELECT acteurs.id, acteurs.prenom, acteurs.nom, jouer.rang FROM acteurs JOIN jouer ON acteurs.id = jouer.idacteur WHERE jouer.idfilm = "+id+";";
	            Statement stmt2 = con.createStatement();
	            ResultSet rslt2 = stmt2.executeQuery(req2);
	            while(rslt2.next()) {
	            	act+="\t\t"+rslt2.getString("nom")+" "+rslt2.getString("prenom")+"\n";
	            }
	            
	            
	            films.add("id : "+id+"\t "+titre+", réalisé en "+ annee + " par : "+nomreal+" "+prenomreal+" ; Noté "+score+"/10 par "+nbvotant+"votants.\n"+act);
	        }

	        return films;
	}
	
	public ArrayList<String> rechercheacteur(String nomacteur,String prenomacteur) throws Exception {
		String req = "SELECT id,nom,prenom FROM [videotheque].[dbo].[acteurs] WHERE nom LIKE '%" + nomacteur + "%' AND prenom LIKE '%" + prenomacteur + "%';";
        Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);

        ArrayList<String> acteurs = new ArrayList<String>();
	        while (rslt.next()) {
	        	int id=rslt.getInt("id");
	            String nom = rslt.getString("nom");
	            String prenom=rslt.getString("prenom");
	            String films= "a joué dans :\n";
	            
	            String req2="SELECT films.titre, films.annee,jouer.rang FROM [videotheque].[dbo].[films] JOIN jouer ON films.id = jouer.idfilm WHERE jouer.idacteur = "+id+";";
	            Statement stmt2 = con.createStatement();
	            ResultSet rslt2 = stmt2.executeQuery(req2);
	            while(rslt2.next()) {
	            	String titre=rslt2.getString("titre");
	            	int annee=rslt2.getInt("annee");
	            	int rang= rslt2.getInt("rang");
	            	films+="\t\t"+titre+" ("+annee+")\tau rang : "+rang+"\n";
	            }
	            
	            acteurs.add(nom+" "+prenom+" "+films);
	        }

	        return acteurs;
	}
	
	public ArrayList<String> recherchereal(String nomreal,String prenomreal) throws Exception {
		String req = "SELECT id,nom,prenom FROM [videotheque].[dbo].[realisateurs] WHERE nom LIKE '%" + nomreal + "%' AND prenom LIKE '%" + prenomreal + "%';";
        Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);

        ArrayList<String> acteurs = new ArrayList<String>();
	        while (rslt.next()) {
	        	int id=rslt.getInt("id");
	            String nom = rslt.getString("nom");
	            String prenom=rslt.getString("prenom");
	            String films= "a réalisé :\n";
	            
	            String req2="SELECT films.titre, films.annee FROM [videotheque].[dbo].[films]  WHERE idrealisateur = "+id+";";
	            Statement stmt2 = con.createStatement();
	            ResultSet rslt2 = stmt2.executeQuery(req2);
	            while(rslt2.next()) {
	            	String titre=rslt2.getString("titre");
	            	int annee=rslt2.getInt("annee");
	            	films+="\t\t"+titre+" ("+annee+")\n";
	            }
	            
	            acteurs.add(nom+" "+prenom+" "+films);
	        }

	        return acteurs;
	}
	
	
	public int realisateurexiste(String nomreal, String prenomreal) throws Exception{
		String req= "SELECT * FROM [videotheque].[dbo].[realisateurs] WHERE nom LIKE '" + nomreal + "'AND prenom LIKE '" + prenomreal + "';";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return rslt.getInt("id");
        }
        else {
        	return 0;
        }
	}
	
	public int acteurexiste(String nomacteur, String prenomacteur) throws Exception{
		String req= "SELECT * FROM [videotheque].[dbo].[realisateurs] WHERE nom LIKE '" + nomacteur + "'AND prenom LIKE '" + prenomacteur + "';";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return rslt.getInt("id");
        }
        else {
        	return 0;
        } 
	}
	
	
	
	
	
	public int creaReal(String nomreal, String prenomreal) throws Exception{
		String req= "INSERT INTO realisateurs (prenom, nom) VALUES ('"+prenomreal+"', '"+nomreal+"');SELECT SCOPE_IDENTITY() AS NouvelID;";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return rslt.getInt("NouvelID");
        }
        else {
        	return 0;
        }
	}
	
	public int creaActeur(String nomacteur, String prenomacteur) throws Exception{
		String req= "INSERT INTO acteurs (prenom, nom) VALUES ('"+prenomacteur+"', '"+nomacteur+"');SELECT SCOPE_IDENTITY() AS NouvelID;";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return rslt.getInt("NouvelID");
        }
        else {
        	return 0;
        }
	}
	
	
	
	
	public String selectionfilm(int idd) throws Exception{
		String req= "SELECT titre FROM [videotheque].[dbo].[films] WHERE id="+idd+";";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return rslt.getString("titre");
        }
        else {
        	return "";
        }
	}
	
	public int comptefilmrealisateur(int idd) throws Exception {
		String req= "SELECT realisateurs.id, COUNT(idrealisateur) FROM films JOIN realisateurs ON realisateurs.id=films.idrealisateur WHERE realisateurs.id="+idd +"GROUP BY realisateurs.id;";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        int compt=0;
        if (rslt.next()){
        	compt=rslt.getInt("");
        }
		return compt;
        
	}
	
	public int comptefilmacteur(int idd) throws Exception {
		String req="SELECT acteurs.id, COUNT(jouer.idfilm) FROM acteurs JOIN jouer ON acteurs.id = jouer.idacteur WHERE acteurs.id="+idd+"GROUP BY acteurs.id;";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        int compt=0;
        if (rslt.next()){
        	compt=rslt.getInt("");
        }
		return compt;
	}
	
	public boolean supprimerfilms(int idd) throws Exception{
		
		String req="SELECT id, titre, annee, idrealisateur FROM [videotheque].[dbo].[films] WHERE id="+idd+";";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	ArrayList<Integer> idacteurs =new ArrayList<>();
        	films f=new films(rslt.getInt("id"),rslt.getString("titre"),rslt.getInt("annee"),rslt.getInt("idrealisateur"));
        	
        	String req2= "SELECT acteurs.id FROM [videotheque].[dbo].[acteurs] JOIN jouer ON acteurs.id = jouer.idacteur WHERE jouer.idfilm = +"+idd+";";
        	Statement stmt2 = con.createStatement();
        	ResultSet rslt2 = stmt2.executeQuery(req2);
            while (rslt2.next()) {
            	idacteurs.add(rslt2.getInt("id"));
            }
            
            String req3= "DELETE FROM [videotheque].[dbo].[jouer] WHERE idfilm="+idd+";SELECT SCOPE_IDENTITY() AS NouvelID;";
            Statement stmt3 = con.createStatement();
            ResultSet rslt5 = stmt3.executeQuery(req3);
            if (rslt5.next()) {
            	for (int a:idacteurs) {
            	if (comptefilmacteur(a)<1) {
	            		req2= "DELETE FROM [videotheque].[dbo].[acteurs] WHERE acteurs.id="+a+";SELECT SCOPE_IDENTITY() AS NouvelID;";
	            		Statement stmt4 = con.createStatement();
	            		@SuppressWarnings("unused")
						ResultSet rslt4 = stmt4.executeQuery(req2);
            		}
                
            	}
            	
            }
            req2="DELETE FROM [videotheque].[dbo].[films] WHERE id="+idd+";SELECT SCOPE_IDENTITY() AS NouvelID;";
            Statement stmt5 = con.createStatement();
            rslt2 = stmt5.executeQuery(req2);
            if (comptefilmrealisateur(f.getIdrealisateur())<=1) {
                req2="DELETE FROM [videotheque].[dbo].[realisateurs] WHERE id="+f.getIdrealisateur()+";SELECT SCOPE_IDENTITY() AS NouvelID;";
                Statement stmt6 = con.createStatement();
                rslt2 = stmt6.executeQuery(req2);
            }
                return true;
        	}
        	
        	
        
        return false;
	}
	
	public boolean verif_filmexiste(String nom,int ann) throws Exception{
		String req="SELECT * FROM [videotheque].[dbo].[films] WHERE titre='"+nom+"' AND annee="+ann+";";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return true;
        }
        else {
        	return false;
        }
	}
	
	public int creafilm(films e) throws Exception{
		String req="INSERT INTO films (titre, annee, score, nbvotant, idrealisateur) VALUES ('"+e.getTitre()+"', "+e.getAnnee()+", "+e.getScore()+","+e.getNbvotant()+", "+e.getIdrealisateur()+");SELECT SCOPE_IDENTITY() AS NouvelID;";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	return rslt.getInt("NouvelID");
        }
        else {
        	return 0;
        }
	}
	
	public void jouer(films e,acteurs f) throws Exception{
		String req="INSERT INTO jouer (idfilm, idacteur, rang) VALUES ("+e.getId()+", "+f.getId()+","+f.getRang()+");SELECT SCOPE_IDENTITY() AS NouvelID;";
		Statement stmt = con.createStatement();
        ResultSet rslt = stmt.executeQuery(req);
        
        if (rslt.next()) {
        	System.out.printf("");
        }
        
        
	}
	
	
}
