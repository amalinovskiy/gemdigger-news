package com.gemdigger.server.model;

import com.google.appengine.api.datastore.Text;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.Set;

@PersistenceCapable
public class NewsBody {

	@PrimaryKey
    @Persistent
    private String url;

    @Persistent
    String title;

    @Persistent
    Set<String> tags;

	@Persistent
    Text body;

    @Persistent
    Text rawHtml;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getBody() {
		return body.getValue();
	}

	public void setBody(String body) {
		this.body = new Text(body);
	}

    public String getRawHtml() {
        return rawHtml.getValue();
    }

    public void setRawHtml(String rawHtml) {
        this.rawHtml = new Text(rawHtml);
    }
}
