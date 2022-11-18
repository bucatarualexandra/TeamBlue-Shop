package sales;

import jakarta.persistence.*;
import lombok.Data;
import products.Item;
import products.Storage;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private Discount discount;
    private boolean isPaid;

    public boolean addItemsToOrder(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        boolean result = items.add(item);
        calculateTotal();
        return result;
    }

    public boolean removeItemsFromOrder(Long id) {
        boolean result = items.removeIf(item -> id.equals(item.getId()));
        if (result) {
            System.out.println("Item removed");
            calculateTotal();
        } else {
            System.out.println("Item not found");
        }
        return result;
//        this.items = items.stream().filter((item) -> !item.getId().equals(id))
//                .collect(Collectors.toList());
    }

    private void calculateTotal() {
        total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        System.out.println("Your total is: " + total);
    }

}

