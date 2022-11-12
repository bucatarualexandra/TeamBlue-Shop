package products;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import utils.Hibernate;
import utils.Management;

import java.util.List;

public class ProductManagement implements Management<Product> {
    @Override
    public void insert(Product item) {
        System.out.println("Persist product ...");
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(item);

            transaction.commit();
        }
    }

    public Product getById(int id) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(Product.class, id);
        }
    }

    public List<Product> getItems() {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            JpaCriteriaQuery<Product> jpaCriteriaQuery = session
                    .getCriteriaBuilder()
                    .createQuery(Product.class);
            jpaCriteriaQuery.from(Product.class);

            TypedQuery<Product> typedQuery = session.createQuery(jpaCriteriaQuery);
            return typedQuery.getResultList();
        }
    }

    @Override
    public void delete(Product item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();
            Product product = getById(item.getId());
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
    public void deleteById(int id) {
        Product p = getById(id);
        delete(p);
    }

    @Override
    public void update(Product item) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            session.beginTransaction();

            session.merge(item);

            session.getTransaction().commit();
        }
    }
}
