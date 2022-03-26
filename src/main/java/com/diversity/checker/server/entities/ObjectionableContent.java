package com.diversity.checker.server.entities;

import javax.persistence.*;

@Entity
public class ObjectionableContent {
    @Column
    String summary;
    @Column(length = 1048576)
    String text;
    @Column
    String selector;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public ObjectionableContent() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public ObjectionableContent(String summary, String text, String selector) {
        this.summary = summary;
        this.text = text;
        this.selector = selector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
