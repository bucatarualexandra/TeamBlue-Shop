package products;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import utils.Hibernate;
import utils.Management;

import java.util.List;

public class ProductManagement implements Management<Item> {
    @Override
    public void insert(Item item) {
        System.out.println("Persist product ...");
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(item);

            transaction.commit();
        }
    }

    public Item getById(Long id) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(Item.class, id);
        }
    }

    public List<Item> getItems() {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            JpaCriteriaQuery<Item> jpaCriteriaQuery = session
                    .getCriteriaBuilder()
                    .createQuery(Item.class);
            jpaCriteriaQuery.from(Item.class);

            TypedQuery<Item> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }

    @Override
    public void delete(Item item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();
            Item product = getById(item.getId());
            if (product == null) {
                System.out.println("Product with ID: " + item.getId() + " not found");
            } else {
                session.remove(product);
                System.out.println("Product with ID: " + item.getId() + " removed");
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        Item p = getById(id);
        delete(p);
    }

    @Override
    public void update(Item item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();

            session.merge(item);

            session.getTransaction().commit();
        }
    }
}
