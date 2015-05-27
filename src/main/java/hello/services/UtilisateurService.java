package hello.services;

import hello.dao.UtilisateurDao;
import hello.objects.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	
	/*
	 * Ajout d(un utilisateur grace à UtilisateurDao.java
	 * Verfie si le nom d'utilisateur et le l'adresse mail sont libre
	 * 
	 * return:
	 * 1 si ok
	 * 2 si le nom d'utilisateur existe deja
	 * 3 si l'adresse mail existe deja
	 * Code erreur sql si erreur lors de la requete
	 */
	public int ajouterUtilisateur(Utilisateur utilisateur)
	{
		
		int res = 0;
		int mail = 0;
		int findName = utilisateurDao.findName(utilisateur.getNom_utilisateur());
		
		if(findName == 0)
		{
			System.out.println( "L'utilisateur n'existe pas");
			mail = utilisateurDao.findMail(utilisateur.getAdresse_mail()); 
			if(mail == 0)
			{
				System.out.println("Ajout de l'utilisateur : " + utilisateur.getNom_utilisateur());
				res = utilisateurDao.creerUtilisateur(utilisateur);
			}
			else
			{
				//L'adresse mail existe deja
				res = 3;
			}
		}
		else
		{
			//le nom d'utilisateur existe deja
			res = 2;
		}
		
		return res;
	}
	
	public int updateUser(Utilisateur utilisateur)
	{
		int ret = 0;
		
		int mail = 0;
		int findName = utilisateurDao.findName(utilisateur.getNom_utilisateur());
		
		if(findName == 0)
		{
			System.out.println( "L'utilisateur n'existe pas");
			mail = utilisateurDao.findMail(utilisateur.getAdresse_mail()); 
			if(mail == 0)
			{
				System.out.println("Ajout de l'utilisateur : " + utilisateur.getNom_utilisateur());
				ret = utilisateurDao.majUtilisateur(utilisateur);
			}
			else
			{
				//L'adresse mail existe deja
				ret = 3;
			}
		}
		else
		{
			//le nom d'utilisateur existe deja
			ret = 2;
		}
		
		return ret;
	}
}
