package products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private Integer stock;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Stock", referencedColumnName = "Id")
    private Product product;

}
