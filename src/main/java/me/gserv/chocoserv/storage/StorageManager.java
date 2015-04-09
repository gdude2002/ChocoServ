package me.gserv.chocoserv.storage;

import me.gserv.chocoserv.storage.entities.Comment;
import me.gserv.chocoserv.storage.entities.Hit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StorageManager {
    private static StorageManager instance = null;

    private SessionFactory sessionFactory;

    private StorageManager() {}

    public static StorageManager getInstance() {
        if (StorageManager.instance == null) {
            StorageManager.instance = new StorageManager();
        }

        return StorageManager.instance;
    }

    public void setUp(String dialect, String driver, String url, String username, String password) {
        Configuration hibernateConfiguration = new Configuration().configure()
                .setProperty("hibernate.dialect", dialect)
                .setProperty("hibernate.connection.driver_class", driver)
                .setProperty("hibernate.connection.url", url)
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password);

        this.sessionFactory = hibernateConfiguration.buildSessionFactory();
    }

    public Session getSession() {
        return this.sessionFactory.openSession();
    }

    public Long getHits(String page) {
        Session s = this.getSession();
        Query q = s.createQuery("SELECT h.hits FROM Hit h WHERE page=?");
        q.setString(0, page);

        Object result = q.uniqueResult();

        s.close();

        if (result == null) {
            return 0L;
        }

        return (Long) result;
    }

    public Long incrementHits(String page) {
        Session s = this.getSession();
        Query q;
        Hit h;

        q = s.createQuery("SELECT h FROM Hit h WHERE page=:page");
        q.setString("page", page);

        Object result = q.uniqueResult();

        if (result == null) {
            h = new Hit(1L, page);
        } else {
            h = (Hit) result;
            h.setHits(h.getHits() + 1L);
        }

        s.save(h);
        s.flush();
        s.close();

        return h.getHits();
    }

    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();

        Session s = this.getSession();
        Query q = s.createQuery("SELECT c FROM Comment c ORDER BY c.id DESC");
        q.setMaxResults(10);

        Comment c;

        for (Object r : q.list()) {
            c = (Comment) r;

            comments.add(c);
        }

        s.close();

        return comments;
    }

    public void addComment(String name, String comment) {
        Session s = this.getSession();
        Comment c = new Comment(name, comment);
        s.save(c);
        s.flush();
        s.close();
    }
}
