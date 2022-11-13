package sales;

import jakarta.persistence.*;
import lombok.Data;
import products.Item;
import user.User;

import java.util.List;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @JoinTable(
            name = "order_items",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")}
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
