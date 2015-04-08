package me.gserv.chocoserv.storage.entities;

public class Hit {
    private long id;
    private Long hits;
    private String page;

    public Hit(Long hits, String page) {
        this.hits = hits;
        this.page = page;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getHits() {
        return this.hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
