package hello.controllers;

import hello.dao.NewsDao;
import hello.objects.News;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsController {
	
	@Autowired
	private NewsDao newsDao;
	
	@RequestMapping(value = "/getAllNews", method = RequestMethod.GET)
	public ArrayList<News> getAllNews( @RequestParam(value = "id", required = true) int idColoc)
	{
		System.out.println("appel controller getAllNews");
		ArrayList<News> list = new ArrayList<News>();
		list= newsDao.getAllNewsDao(idColoc);
		
		return list;
		
		
	}
	
	@RequestMapping("/addNews")
	public String addNews(@RequestParam(value = "text", required = true) String text, @RequestParam(value = "id_coloc", required = true) int id_coloc)
	{
		News _news = new News(text,id_coloc);
		
		String ret = newsDao.addNewsDao(_news);
		
		return ret;
	}
	
	@RequestMapping("/deleteNews")
	public int deleteNews(@RequestParam(value = "id", required = true) int id)
	{
		int ret = newsDao.deleteNewsDao(id);
		
		return ret;
	}


}
