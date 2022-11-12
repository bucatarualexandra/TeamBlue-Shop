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
    public List<Product> getProducts() {
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
            Product product = getProducts(id);
            if (product == null) {
                System.out.println("Product with ID: " + id + " not found");
            } else {
                session.remove(product);
                System.out.println("Product with ID: " + id + " removed");
            }
            session.getTransaction().commit();
        }
    }


    @Override
    public void get() {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(Product.class, id);
        }
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
