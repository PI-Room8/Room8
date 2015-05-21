package hello.dao;

import hello.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;



@Component
public class ColocationDao {

	public int getIdCollocationByUserId(int userId)
	{
		Connection conn = JdbcConnection.connect();
		int _id = 0;
		try{	
			
			String sql = "SELECT Id_colocation from utilisateurs where id_utilisateur =?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1,userId);
			
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
}
