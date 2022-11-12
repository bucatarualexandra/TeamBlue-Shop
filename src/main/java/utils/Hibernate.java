package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernate {
    private static Hibernate instance;

    private final SessionFactory sf;

    private Hibernate() {
        sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Hibernate getInstance() {
        if (instance == null) {
            instance = new Hibernate();
        }
        return instance;
    }

    public SessionFactory getSessions() {
        return sf;
    }
}
