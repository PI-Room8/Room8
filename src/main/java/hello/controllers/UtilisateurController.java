package hello.controllers;

import hello.dao.ColocationDao;
import hello.dao.UtilisateurDao;
import hello.objects.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class UtilisateurController {
	
	@Autowired 
	private UtilisateurDao utilisteurDao;
	
	@Autowired ColocationDao colocationDao;
	
	@RequestMapping("/creerUtilisateur")
	public String creerUtilisateur(@RequestParam(value="nom", required=true) String nom,
			@RequestParam(value="mdp", required=true) String mdp,
			@RequestParam(value="mail", required=true) String mail)
	{
		System.out.println("appel creation");
		Utilisateur user = new Utilisateur(nom,mdp,mail);
		return utilisteurDao.creerUtilisateur(user);
	}
	
	
	@RequestMapping("/majUtilisateur")
	public String majUtilisateur(@RequestParam(value="id", required=true) int id,
			@RequestParam(value="nom", required=true) String nom,
			@RequestParam(value="mdp", required=true) String mdp,
			@RequestParam(value="mail", required=true) String mail)
	{
		Utilisateur user = new Utilisateur(id,nom,mdp,mail);
		return utilisteurDao.majUtilisateur(user);
	}
	
	@RequestMapping("/getUserColocation")
	public int getUserColocation(@RequestParam(value="id", required=true) int id)
	{
		int id_colocation = 0;
		
		id_colocation = colocationDao.getIdCollocationByUserId(id);
		
		return id_colocation;
	}
}
