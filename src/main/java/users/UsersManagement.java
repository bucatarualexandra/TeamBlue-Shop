package users;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import utils.Hibernate;
import utils.Management;
import java.util.List;

public class UsersManagement implements Management<User> {
    @Override
    public void insert(User item) {
        System.out.println("User added ...");
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(item);

            transaction.commit();
        }
    }

    public User getById(int id) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> getItems() {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            JpaCriteriaQuery<User> jpaCriteriaQuery = session
                    .getCriteriaBuilder()
                    .createQuery(User.class);
            jpaCriteriaQuery.from(User.class);

            TypedQuery<User> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }

    @Override
    public void delete(User item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();
            User user = getById(item.getId());
            if (user == null) {
                System.out.println("User with ID: " + item.getId() + " not found");
            } else {
                session.remove(user);
                System.out.println("User with ID: " + item.getId() + " removed");
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(int id) {
        User p = getById(id);
        delete(p);
    }

    @Override
    public void update(User item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();

            session.merge(item);

            session.getTransaction().commit();
        }
    }
}
