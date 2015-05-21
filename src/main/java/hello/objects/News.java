package hello.objects;

public class News {

	private int id_news;
	private String text;
	private int id_coloc;
	private String date;
	
	public News() {
		
	}
	
	public News(String text, int id_coloc) {
		this.text = text;
		this.id_coloc = id_coloc;
	}

	public News(int id_news, String text, int id_coloc, String date) {
		this.id_news = id_news;
		this.text = text;
		this.id_coloc = id_coloc;
		this.date = date;
	}


	public int getId_news() {
		return id_news;
	}


	public void setId_news(int id_news) {
		this.id_news = id_news;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getId_coloc() {
		return id_coloc;
	}


	public void setId_coloc(int id_coloc) {
		this.id_coloc = id_coloc;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	
	
	
	
	
}
