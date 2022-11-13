package sales;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Integer amount;
}
