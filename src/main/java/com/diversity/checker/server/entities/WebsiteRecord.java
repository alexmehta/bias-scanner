package com.diversity.checker.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WebsiteRecord {
    @Id
    String url;
    @Column
    Double score;
    @OneToMany
    List<ObjectionableContent> objectionableContentList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<ObjectionableContent> getObjectionableContentList() {
        return objectionableContentList;
    }

    public void setObjectionableContentList(List<ObjectionableContent> objectionableContentList) {
        this.objectionableContentList = objectionableContentList;
    }

    public WebsiteRecord() {
    }

    public WebsiteRecord(String url) {
        this.url = url;
        objectionableContentList = new ArrayList<>();
    }
}
