package hello.dao;

import hello.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;



@Component
public class ColocationDao {

	//Fonction qui retourne l'id d'une colocation en fonction du nom d'utilisateur passé en parametre
	public int getIdCollocationByUsername(String username)
	{
		Connection conn = JdbcConnection.connect();
		int _id = 0;
		try{	
			
			String sql = "SELECT Id_colocation from utilisateurs where Nom_utilisateur = ?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1,username);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
			{
				_id = rs.getInt("Id_colocation");
			}
			
		}
		catch(SQLException s){
			s.printStackTrace();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return _id;
		
		}
	
	
	public int insertColocation(String name)
	{

		Connection conn = JdbcConnection.connect();
		int ret = 0;
		try
		{
			String sql = "INSERT into colocations(Nombre_colocataire,Nom_colocation) VALUES(1,?)";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, name);
						
			ret = prep.executeUpdate();	
			
				
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
	
	//Check si le nom de la colocation existe déja
	//Retourne 0 si le nom existe pas et 1 ou + si il existe
	public int checkFlatName(String name)
	{
		Connection conn = JdbcConnection.connect();
		
		Statement stmt = null;
		int res = 0;
		
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM colocations WHERE Nom_colocation = \"" + name +" \" ";
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
			res = s.getErrorCode();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return res;
		
	}
	
	/*
	 * Fonction qui renvoi le nombre de colocataire en fonction de l'id de la colocation
	 * 
	 * return
	 * int nombre colocataire
	 * ou code erreur sql
	 */
	public int getNumberFlatmate(int id_colocation)
	{
		Connection conn = JdbcConnection.connect();
		int nbColoc = 0;
		Statement stmt = null;
	
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT Nombre_colocataire FROM colocations WHERE Id_colocation = \"" + id_colocation +" \" ";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	  nbColoc = rs.getInt("Nombre_colocataire");
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		}
		catch(SQLException s){
			s.printStackTrace();
			nbColoc = s.getErrorCode();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return nbColoc; 
	}
	
	public int deleteColocation(int id_colocation)
	{
		int ret = 0;
		
		Connection conn = JdbcConnection.connect();
		
		try
		{
			String sql = "DELETE FROM colocations WHERE Id_colocation = ?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, id_colocation);
						
			ret = prep.executeUpdate();	
			
				
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
	
	
}
