package products;

import jakarta.persistence.*;
import lombok.Data;
import sales.OrderItem;

import java.util.List;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String productName;
    private Double price;
    private String description;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item")
    private Storage storage;

    @ManyToMany
    private List<OrderItem> orderItem;


}
