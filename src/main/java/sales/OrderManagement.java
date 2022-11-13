package sales;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import utils.Hibernate;
import utils.Management;

import java.util.List;

public class OrderManagement implements Management<OrderItem> {
    @Override
    public void insert(OrderItem item) {
        System.out.println("Persist order ...");
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(item);

            transaction.commit();
        }
    }

    public OrderItem getById(Long id) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(OrderItem.class, id);
        }
    }

    public List<OrderItem> getItems() {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            JpaCriteriaQuery<OrderItem> jpaCriteriaQuery = session
                    .getCriteriaBuilder()
                    .createQuery(OrderItem.class);
            jpaCriteriaQuery.from(OrderItem.class);

            TypedQuery<OrderItem> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }

    @Override
    public void delete(OrderItem item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();
            OrderItem orderItem = getById(item.getId());
            if (orderItem == null) {
                System.out.println("Order with ID: " + item.getId() + " not found");
            } else {
                session.remove(orderItem);
                System.out.println("Order with ID: " + item.getId() + " removed");
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        OrderItem p = getById(id);
        delete(p);
    }

    @Override
    public void update(OrderItem item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();

            session.merge(item);

            session.getTransaction().commit();
        }
    }
}
