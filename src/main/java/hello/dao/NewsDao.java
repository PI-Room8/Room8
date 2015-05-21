package hello.dao;

import hello.jdbc.JdbcConnection;
import hello.objects.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class NewsDao {
	
	
	public ArrayList<News> getAllNewsDao(int id_coloc)
	{
		
		Connection conn = JdbcConnection.connect();
		Statement stmt = null;
		News news = null;
		ArrayList<News> listNews = new ArrayList<News>();
		try{
			
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM news WHERE Id_colocation = " + id_coloc ;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next())
		      {
		    	  int id = rs.getInt("Id_news");
		    	  String nouvelle = rs.getString("Text");
		    	  int id_colocation = rs.getInt("Id_colocation");
		    	  String date = rs.getString("Date");
		    	 
		    	  news = new News(id,nouvelle,id_colocation,date);
		    	  listNews.add(news);
		    	  
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
		
		
		return listNews;
		
		
	}
	
	public int addNewsDao(News news)
	{
		Connection conn = JdbcConnection.connect();
		int ret = 0;
		
		try
		{
			
			String sql = "INSERT into news(Text,Id_colocation,Date) VALUES(?,?,NOW())";
			PreparedStatement prep = conn.prepareStatement(sql); 
			prep.setString(1, news.getText());
			prep.setInt(2, news.getId_coloc());
			
			ret = prep.executeUpdate();
			
			System.out.println("Retour sql = " + ret);
				
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	public int deleteNewsDao(int id)
	{
		Connection conn = JdbcConnection.connect();
		int ret = 0;
		try
		{
			
			String sql = "DELETE FROM news WHERE Id_news =" + id;
			PreparedStatement prep = conn.prepareStatement(sql); 
			
			
			ret = prep.executeUpdate();
			
			System.out.println("Retour sql = " + ret);
			
			
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
}
