package hello.dao;

import hello.jdbc.JdbcConnection;
import hello.objects.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class UtilisateurDao {
	
	public String creerUtilisateur(Utilisateur utilisateur)
	{
		Connection conn = JdbcConnection.connect();
		
		try
		{
			String sql = "INSERT into utilisateurs(Nom_utilisateur,Mot_de_passe,Adresse_mail,Id_colocation) VALUES(?,?,?,NULL)";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, utilisateur.getNom_utilisateur());
			prep.setString(2, utilisateur.getMot_de_passe());
			prep.setString(3, utilisateur.getAdresse_mail());
		
			
			prep.executeUpdate();	
				
		}
		catch(SQLException s){
			System.out.println("Exception :" + s.toString());
			return s.getClass().toString();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "ok";
	}

}
