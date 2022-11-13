package user;

import jakarta.persistence.*;
import lombok.Data;
import sales.OrderItem;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String userName;
    private String address;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Id")
    private List<OrderItem> orderItem;

}
