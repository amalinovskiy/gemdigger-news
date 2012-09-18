package com.gemdigger.server.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemdigger.server.dao.NewsDao;
import com.gemdigger.server.model.Action;
import com.gemdigger.server.model.NewsAction;

@Controller
public class InfoController {
	
	public static final Logger log = Logger.getLogger(InfoController.class.getName());
	
	@Autowired
	NewsDao newsDao;
	
	@RequestMapping("/record")
	public @ResponseBody InfoStatus recordAction(@RequestParam String userId, @RequestParam Action action, @RequestParam String url) {
		
		try {
			newsDao.saveAction(userId, action, url);	
		} catch (Throwable ex) {
			log.log(Level.SEVERE, ex.getMessage(), ex);
			
			return InfoStatus.FAILED;
		}
		
		
		return InfoStatus.SUBMITTED;
	}
	
	@RequestMapping("/list")
	public @ResponseBody List<NewsAction> list(@RequestParam String userId, @RequestParam Boolean withBody) {
		return newsDao.listActions(userId, withBody);
	}
	
	
}