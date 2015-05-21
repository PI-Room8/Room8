package hello.objects;

public class Utilisateur {

	private int id_utilisateur;
	private String nom_utilisateur;
	private String mot_de_passe;
	private String adresse_mail;
	private int id_colocation;
	
	public Utilisateur() {};
	
	
	
	public Utilisateur(String nom_utilisateur, String mot_de_passe,
			String adresse_mail) {
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_passe = mot_de_passe;
		this.adresse_mail = adresse_mail;
	}



	public Utilisateur(int id_utilisateur, String nom_utilisateur,
			String mot_de_passe, String adresse_mail, int id_colocation)
	{
		this.id_utilisateur = id_utilisateur;
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_passe = mot_de_passe;
		this.adresse_mail = adresse_mail;
		this.id_colocation = id_colocation;
	}
	
	
	public int getId_utilisateur() 
	{
		return id_utilisateur;
	}


	public void setId_utilisateur(int id_utilisateur) 
	{
		this.id_utilisateur = id_utilisateur;
	}


	public String getNom_utilisateur()
	{
		return nom_utilisateur;
	}


	public void setNom_utilisateur(String nom_utilisateur) 
	{
		this.nom_utilisateur = nom_utilisateur;
	}


	public String getMot_de_passe() 
	{
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe)
	{
		this.mot_de_passe = mot_de_passe;
	}


	public String getAdresse_mail()
	{
		return adresse_mail;
	}


	public void setAdresse_mail(String adresse_mail)
	{
		this.adresse_mail = adresse_mail;
	}


	public int getId_colocation() 
	{
		return id_colocation;
	}


	public void setId_colocation(int id_colocation)
	{
		this.id_colocation = id_colocation;
	}



	
}
