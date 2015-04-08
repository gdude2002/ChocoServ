package me.gserv.chocoserv.storage.entities;

public class Comment {
    private long id;
    private String name;
    private String comment;

    public Comment() {}

    public Comment(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
