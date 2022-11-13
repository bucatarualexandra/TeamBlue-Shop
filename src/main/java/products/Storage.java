package products;

import jakarta.persistence.*;
import lombok.Data;

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

}
