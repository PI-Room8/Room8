package hello.controllers;

import hello.dao.ColocationDao;
import hello.dao.UtilisateurDao;
import hello.objects.Utilisateur;
import hello.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class UtilisateurController {
	
	@Autowired 
	private UtilisateurDao utilisteurDao;
	
	@Autowired 
	private ColocationDao colocationDao;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@RequestMapping("/addUser")
	public int creerUtilisateur(@RequestParam(value="nom", required=true) String nom,
			@RequestParam(value="mdp", required=true) String mdp,
			@RequestParam(value="mail", required=true) String mail)
	{
		System.out.println("appel creation");
		Utilisateur user = new Utilisateur(nom,mdp,mail);
		return utilisateurService.ajouterUtilisateur(user);
	}
	
	
	@RequestMapping("/updateUser")
	public int majUtilisateur(@RequestParam(value="id", required=true) int id,
			@RequestParam(value="nom", required=true) String nom,
			@RequestParam(value="mdp", required=true) String mdp,
			@RequestParam(value="mail", required=true) String mail)
	{
		Utilisateur user = new Utilisateur(id,nom,mdp,mail);
		return utilisateurService.updateUser(user);
	}
	
	@RequestMapping("/getUserFlat")
	public int getUserColocation(@RequestParam(value="name", required=true) String name)
	{
		int id_colocation = 0;
		
		id_colocation = colocationDao.getIdCollocationByUsername(name);
		
		return id_colocation;
	}
	
	@RequestMapping("/getPassword")
	public String getPaswword(@RequestParam(value="nom", required=true) String nom)
	{
		String mdp = utilisteurDao.getMdp(nom);
		
		return mdp;
	}
	
	@RequestMapping("/getProfile")
	public Utilisateur getProfile(@RequestParam(value="id", required=true)int id)
	{
		return utilisateurDao.getUserProfileById(id);
	}
	
	@RequestMapping("/getUser")
	public Utilisateur getUser(@RequestParam(value="name", required = true)String username)
	{
		return utilisateurDao.getUserProfileByName(username);
	}
}
