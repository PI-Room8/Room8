package hello.controllers;

import hello.services.ColocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColocationController {
	
	@Autowired
	private ColocationService colocationService;
	
	
	/*
	 * Insert d'une colocation dans la base
	 * 
	 * Return:
	 * 1 si ok
	 * 0 si le nom de la colocation existe déja
	 * Code erreur sql si erreur requete
	 * 
	 */
	@RequestMapping("/createFlat")
	public int createFlat(@RequestParam(value="name", required=true)String name)
	{
		int ret = 0;
		ret = colocationService.addColocation(name); 
		return ret;
	}
	
	/*
	 * Supprime une colocation de la base
	 * 
	 * return : 
	 * 1 si supprimé
	 * 2 si nombre_colocataire > 1
	 * ou code erreur SQL
	 *
	 */
	@RequestMapping("/deleteFlat")
	public int deleteFlat(@RequestParam(value="idColoc", required=true)int idColoc)
	{
		return colocationService.deleteColcation(idColoc);
	}

}
