package hello.objects;

public class Colocation {
	
	private int id_colocation;
	private String nom;
	private int nombre_colocataire;
	private int id_liste_course;
	private int id_liste_tache;
	
	public Colocation () {}
	
	public Colocation(int id_colocation, String nom, int nombre_colocataire,
			int id_liste_course, int id_liste_tache)
	{
		this.id_colocation = id_colocation;
		this.nom = nom;
		this.nombre_colocataire = nombre_colocataire;
		this.id_liste_course = id_liste_course;
		this.id_liste_tache = id_liste_tache;
	}

	public int getId_colocation() {
		return id_colocation;
	}

	public void setId_colocation(int id_colocation) {
		this.id_colocation = id_colocation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombre_colocataire() {
		return nombre_colocataire;
	}

	public void setNombre_colocataire(int nombre_colocataire) {
		this.nombre_colocataire = nombre_colocataire;
	}

	public int getId_liste_course() {
		return id_liste_course;
	}

	public void setId_liste_course(int id_liste_course) {
		this.id_liste_course = id_liste_course;
	}

	public int getId_liste_tache() {
		return id_liste_tache;
	}

	public void setId_liste_tache(int id_liste_tache) {
		this.id_liste_tache = id_liste_tache;
	}
	
	
	
	

}
