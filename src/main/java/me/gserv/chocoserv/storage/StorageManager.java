package me.gserv.chocoserv.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
}
