package hello.services;

import hello.dao.ColocationDao;
import hello.dao.UtilisateurDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColocationService {
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private ColocationDao colocationDao;
	
	//Fonction qui ajoute une colocation
	//Return 1 si ok
	//		 0 ou code erreur sql si erreur
	public int addColocation(String name)
	{
		int nom_existe = 0;
		int ret = 0;

		nom_existe = colocationDao.checkFlatName(name);
		if(nom_existe == 0)
		{
			ret = colocationDao.insertColocation(name);
		}
		else
		{
			ret = 0;
		}
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
	public int deleteColcation(int idColoc)
	{
		int ret = 0;
		int nbFlatmate = 0;
		
		nbFlatmate = colocationDao.getNumberFlatmate(idColoc);
		
		if(nbFlatmate == 1)
		{
			ret = colocationDao.deleteColocation(idColoc);
		}
		else
		{
			ret = 2;
		}
		
		return ret;
	}
}
