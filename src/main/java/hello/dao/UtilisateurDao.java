package hello.dao;

import hello.jdbc.JdbcConnection;
import hello.objects.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class UtilisateurDao {
	
	/*
	 * Ajout d'un utilisateur dans la base
	 * 
	 * return:
	 * 1 si ok
	 * 0 ou code erreur sql si erreur
	 * 
	 */
	public int creerUtilisateur(Utilisateur utilisateur)
	{
		Connection conn = JdbcConnection.connect();
		int ret = 0;
		try
		{
			String sql = "INSERT into utilisateurs(Nom_utilisateur,Mot_de_passe,Adresse_mail,Id_colocation) VALUES(?,?,?,NULL)";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, utilisateur.getNom_utilisateur());
			prep.setString(2, utilisateur.getMot_de_passe());
			prep.setString(3, utilisateur.getAdresse_mail());
		
			prep.executeUpdate();
			ret = 1;
				
		}
		catch(SQLException s){
			System.out.println("Exception :" + s.toString());
			ret = s.getErrorCode();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return ret;
	}
	
	//Fonction qui met à jour un utilisateur
	//Retourne "ok" si la mise à jour est effectuée
	public int majUtilisateur(Utilisateur utilisateur)
	{
		Connection conn = JdbcConnection.connect();
		int ret = 0;
		try
		{
			String sql = "UPDATE utilisateurs SET Nom_utilisateur=?, Mot_de_passe=?, Adresse_mail=? WHERE Id_utilisateur=?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, utilisateur.getNom_utilisateur());
			prep.setString(2, utilisateur.getMot_de_passe());
			prep.setString(3, utilisateur.getAdresse_mail());
			prep.setInt(4, utilisateur.getId_utilisateur());
		
			
			prep.executeUpdate();	
			ret = 1;
				
		}
		catch(SQLException s){
			System.out.println("Exception :" + s.toString());
			ret = s.getErrorCode();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return ret;
	}
	
	//La fonction retourne 0 si le nom existe pas et 1 (ou +) si il existe
	public int findName(String _nom)
	{
		
		Connection conn = JdbcConnection.connect();
		Statement stmt = null;
		
		int res = 0;
		
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM utilisateurs WHERE Nom_utilisateur = \"" + _nom +" \" ";
		      ResultSet rs = stmt.executeQuery(sql);
		      rs.last();
		      res = rs.getRow();
		      System.out.println("nbRow = " + res);
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return res;
		
		
	}
	
	//La fonction retourne 0 si l'@ mail n'existe pas et 1 (ou +) sinon
	public int findMail(String _mail)
	{
		
		Connection conn = JdbcConnection.connect();
		Statement stmt = null;
		
		int res = 0;
		
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM utilisateurs WHERE Adresse_mail = \"" + _mail +" \" ";
		      ResultSet rs = stmt.executeQuery(sql);
		      rs.last();
		      res = rs.getRow();
		      System.out.println("nbRow = " + res);
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return res;
		
		
	}
	
	public String getMdp(String _nom)
	{
		Connection conn = JdbcConnection.connect();
		Statement stmt = null;
		String _mdp = null;
		
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT Mot_de_passe FROM utilisateurs WHERE Nom_utilisateur = \"" + _nom +" \" ";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	 _mdp = rs.getString("Mot_de_passe");
		      }
		     
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return _mdp;
	}
	
	//Fonction qui renvoi les informations de l'utilisarteur en fonction de son id
	public Utilisateur getUserProfileById(int _id)
	{
		Connection conn = JdbcConnection.connect();
		Statement stmt = null;
		Utilisateur user = new Utilisateur();
		
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM utilisateurs WHERE Id_utilisateur = \"" + _id +" \" ";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		     
		      while(rs.next())
		      {
		    	 int id = _id;
		    	 String nom = rs.getString("Nom_utilisateur");
		    	 String mdp = rs.getString("Mot_de_passe");
		    	 String mail = rs.getString("Adresse_mail");
		    	 int coloc = rs.getInt("Id_colocation");
		    	 
		    	 user.setId_utilisateur(id);
		    	 user.setMot_de_passe(mdp);
		    	 user.setAdresse_mail(mail);
		    	 user.setNom_utilisateur(nom);
		    	 user.setId_colocation(coloc);
		      }
		      
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	//Fonction qui renvoi les informations de l'utilisarteur en fonction de son id
		public Utilisateur getUserProfileByName(String name)
		{
			Connection conn = JdbcConnection.connect();
			Statement stmt = null;
			Utilisateur user = new Utilisateur();
			
			try{
				
			      stmt = conn.createStatement();
			      String sql = "SELECT * FROM utilisateurs WHERE Nom_utilisateur = \"" + name+" \" ";
			      ResultSet rs = stmt.executeQuery(sql);
			      
			     
			      while(rs.next())
			      {
			    	 int id = rs.getInt("Id_utilisateur");
			    	 String nom = rs.getString("Nom_utilisateur");
			    	 String mdp = rs.getString("Mot_de_passe");
			    	 String mail = rs.getString("Adresse_mail");
			    	 int coloc = rs.getInt("Id_colocation");
			    	 
			    	 user.setId_utilisateur(id);
			    	 user.setMot_de_passe(mdp);
			    	 user.setAdresse_mail(mail);
			    	 user.setNom_utilisateur(nom);
			    	 user.setId_colocation(coloc);
			      }
			      
			      rs.close();
			      stmt.close();
			      conn.close();
			      
			}
			catch(SQLException s){
				s.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return user;
		}

}
