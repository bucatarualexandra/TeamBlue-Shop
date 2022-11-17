package products;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import utils.Hibernate;

import java.util.List;

@Entity
@Data
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Integer stock;

    @OneToOne
    @MapsId
    @JoinColumn(name = "Id")
    private Item item;

    public void increment() {
        stock += 1;
    }

    public void decrement() {
        if (stock != 0) {
            stock -= 1;
        }
    }

//    public Storage getById(Long id) {
//        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
//            return session.get(Storage.class, id);
//        }
//    }

//    public Integer getById(Long id) {
//        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
//            return session.get(Storage.class, id).getStock();
//        }
//    }
//
//    public List<Storage> getStorage() {
//        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
//            JpaCriteriaQuery<Storage> jpaCriteriaQuery = session
//                    .getCriteriaBuilder()
//                    .createQuery(Storage.class);
//            jpaCriteriaQuery.from(Storage.class);
//
//            TypedQuery<Storage> typedQuery = session.createQuery(jpaCriteriaQuery);
//            return typedQuery.getResultList();
//        }
//    }
}
