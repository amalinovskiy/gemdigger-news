package com.gemdigger.server.dao;

import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Service;

import com.gemdigger.server.model.Action;
import com.gemdigger.server.model.NewsAction;

@Service
public class NewsDao {

	public static final Logger log = Logger.getLogger(NewsDao.class.getName());
	
	public void saveAction(String userId, Action action, String url) {
		NewsAction newsAction = new NewsAction();
		
		newsAction.setAction(action);
		newsAction.setUrl(url);
		newsAction.setUserId(userId);
		
		PersistenceManager manager = PMF.get().getPersistenceManager();
		try {
			manager.makePersistent(newsAction);
		} finally {
			manager.close();
		}
		
		log.info("Saved action: " + newsAction.toString());
	}

}
