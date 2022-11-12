package sales;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import users.User;
import utils.Hibernate;
import utils.Management;

import java.util.List;

public class OrderManagement implements Management<Order> {
    @Override
    public void insert(Order item) {
        System.out.println("Persist order ...");
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(item);

            transaction.commit();
        }
    }

    public Order getById(int id) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(Order.class, id);
        }
    }

    public List<Order> getItems() {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            JpaCriteriaQuery<Order> jpaCriteriaQuery = session
                    .getCriteriaBuilder()
                    .createQuery(Order.class);
            jpaCriteriaQuery.from(Order.class);

            TypedQuery<Order> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }

    @Override
    public void delete(Order item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();
            Order order = getById(item.getId());
            if (order == null) {
                System.out.println("Order with ID: " + item.getId() + " not found");
            } else {
                session.remove(order);
                System.out.println("Order with ID: " + item.getId() + " removed");
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(int id) {
        Order p = getById(id);
        delete(p);
    }

    @Override
    public void update(Order item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();

            session.merge(item);

            session.getTransaction().commit();
        }
    }
}
