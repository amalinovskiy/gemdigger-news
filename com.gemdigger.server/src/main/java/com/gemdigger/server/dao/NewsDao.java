package com.gemdigger.server.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.gemdigger.server.model.NewsBody;
import org.springframework.stereotype.Service;

import com.gemdigger.server.model.Action;
import com.gemdigger.server.model.NewsAction;

@Service
public class NewsDao {

	public static final Logger log = Logger.getLogger(NewsDao.class.getName());
	
	public void saveAction(NewsAction newsAction) {

		PersistenceManager manager = PMF.get().getPersistenceManager();
		try {
			manager.makePersistent(newsAction);
		} finally {
			manager.close();
		}
		
		log.info("Saved new action: " + newsAction.toString());
	}

    public void saveNewsBody(NewsBody newsBody) {
        PersistenceManager manager = PMF.get().getPersistenceManager();
        try {
            manager.makePersistent(newsBody);
        } finally {
            manager.close();
        }

        log.info("Saved new news body: " + newsBody.getUrl());
    }
	
	@SuppressWarnings("unchecked")
	public List<NewsAction> listActions(String userId, boolean withBody) {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		
		Query q = manager.newQuery(NewsAction.class, "userId == userIdParam");
		q.setOrdering("created desc");
		q.declareParameters("String userIdParam");

		try {
			if (!withBody) {
				return (List<NewsAction>)q.execute(userId);				
			} else {
				List<NewsAction> actions = (List<NewsAction>)q.execute(userId);
				
				for  (NewsAction action : actions) {
                    manager.getObjectById(action.getUrl());
					action.setBody(null);
				}

				return actions;
			}
			
		} finally {
			q.closeAll();
            manager.close();
		}
	}

    public NewsAction getActionById(Long id) {
        PersistenceManager manager = PMF.get().getPersistenceManager();

        try {
            return (NewsAction)manager.getObjectById(id);
        }  finally {
            manager.close();
        }
    }

    public NewsBody getBodyByUrl(String url) {
        PersistenceManager manager = PMF.get().getPersistenceManager();

        try {
            return (NewsBody)manager.getObjectById(url);
        }  finally {
            manager.close();
        }
    }

}
