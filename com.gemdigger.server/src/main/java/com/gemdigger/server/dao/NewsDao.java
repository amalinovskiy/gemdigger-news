package com.gemdigger.server.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
		newsAction.setCreated(new Date());
		
		PersistenceManager manager = PMF.get().getPersistenceManager();
		try {
			manager.makePersistent(newsAction);
		} finally {
			manager.close();
		}
		
		log.info("Saved action: " + newsAction.toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<NewsAction> listActions(String userId, boolean withBody) {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		
		Query q = manager.newQuery(NewsAction.class, "userId == userIdParam");
		q.setOrdering("created desc");
		q.declareParameters("String userIdParam");

		try {
			if (withBody) {
				return (List<NewsAction>)q.execute(userId);				
			} else {
				List<NewsAction> actions = (List<NewsAction>)q.execute(userId);
				
				for  (NewsAction action : actions) {
					action.setBody(null);
				}

				return actions;
			}
			
		} finally {
			q.closeAll();
		}
	}

}
