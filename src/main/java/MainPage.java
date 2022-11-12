import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainPage {
    public static void main(String[] args) {

    }

    static SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
}
