package com.diversity.checker.server.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WebsiteLedger {
    @OneToMany
    List<WebsiteRecord> recordList;
    @Id
    String url;

    public WebsiteLedger(String id) {
        url = id;
        recordList = new ArrayList<>();
    }

    public List<WebsiteRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<WebsiteRecord> recordList) {
        this.recordList = recordList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WebsiteLedger(List<WebsiteRecord> recordList, String url) {
        this.recordList = recordList;
        this.url = url;
    }

    public WebsiteLedger() {

    }


}
