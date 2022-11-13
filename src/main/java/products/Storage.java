package products;

import jakarta.persistence.*;
import lombok.Data;
import sales.OrderItem;

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
}
