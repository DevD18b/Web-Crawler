package com.company.entities;

public class CrawlerResults {
    public String title;
    public String link;

    public String res;
    public CrawlerResults(){}
    public CrawlerResults(String query){
        this.res = query;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
