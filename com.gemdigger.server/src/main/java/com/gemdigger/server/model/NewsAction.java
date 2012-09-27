package com.gemdigger.server.model;

import java.util.Date;

import javax.jdo.annotations.*;

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

    /**
     * Url which came with an action - may contain tracking params and such
     */
	@Persistent
	private String url;

    /**
     * Final canonical url of the news body of the action
     */
    @Persistent
    private String canonicalUrl;
	
	@Persistent
	private Date created;

    @NotPersistent
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

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
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
