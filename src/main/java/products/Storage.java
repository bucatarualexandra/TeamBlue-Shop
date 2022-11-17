package products;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Session;
import utils.Hibernate;

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

    public Storage getById(Long id) {
        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
            return session.get(Storage.class, id);
        }
    }
}
