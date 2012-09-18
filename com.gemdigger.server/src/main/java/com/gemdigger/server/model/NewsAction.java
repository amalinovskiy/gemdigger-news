package com.gemdigger.server.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Represents a user interaction with a news item 
 * @author Anton Malinovskiy
 */
@PersistenceCapable
public class NewsAction {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String userId;

	@Persistent
	private Action action;

	@Persistent
	private String url;
	
	@Persistent
	private Date created;
	
	@Persistent
	private NewsBody body;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public NewsBody getBody() {
		return body;
	}

	public void setBody(NewsBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "NewsAction [id=" + id + ", userId=" + userId + ", action="
				+ action + ", url=" + url + ", created=" + created +"]";
	}
}
