package hello.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static Connection connect()
	{
		//Parametre de la connexion
		final String url = "jdbc:mysql://aatskjnjhhrljq.csvgr5yn3841.us-west-2.rds.amazonaws.com:3306/room8_db";
				
		final String username = "room8";
		final String password = "adminroom8";
		Connection conn = null;
		
		try{
			
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(url,username,password);
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
