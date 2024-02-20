package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connexion {
	private String user;
	private String mdp;
	
	public connexion() {
		user=null;
		mdp=null;
	}
	
	public boolean bdd() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//2. Connexion à la BD
		String urlBD = "jdbc:sqlserver://localhost;databaseName=videotheque;integratedSecurity=true;encrypt=false";
		Connection con = DriverManager.getConnection(urlBD);
		
		//3. Lancement de la requête
		String req="SELECT login,mdp FROM [videotheque].[dbo].[user] WHERE login='"+user+"'AND mdp='"+mdp+"';";
		Statement stmt = con.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		
		return rslt.next();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
