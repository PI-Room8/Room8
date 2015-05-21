package hello.controllers;

import hello.dao.UtilisateurDao;
import hello.objects.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class CreerUtilisateur {
	
	@Autowired 
	private UtilisateurDao utilisteurDao;
	
	@RequestMapping("/creerUtilisateur")
	public String creerUtilisateur(@RequestParam(value="nom", required=true) String nom,
			@RequestParam(value="mdp", required=true) String mdp,
			@RequestParam(value="mail", required=true) String mail)
	{
		Utilisateur user = new Utilisateur(nom,mdp,mail);
		return utilisteurDao.creerUtilisateur(user);
	}
}
