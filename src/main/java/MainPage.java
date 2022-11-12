import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainPage {
    public static void main(String[] args) {
        System.out.println("Hello");

    }

    static SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();


}

