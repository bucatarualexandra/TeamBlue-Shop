package products;

import jakarta.persistence.*;
import sales.OrderItem;

import java.util.List;

@Entity
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

    public Item() {
    }


    public Long getId() {
        return this.Id;
    }

    public String getProductName() {
        return this.productName;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public List<OrderItem> getOrderItem() {
        return this.orderItem;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Item)) return false;
        final Item other = (Item) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$Id = this.getId();
        final Object other$Id = other.getId();
        if (this$Id == null ? other$Id != null : !this$Id.equals(other$Id)) return false;
        final Object this$productName = this.getProductName();
        final Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$storage = this.getStorage();
        final Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) return false;
        final Object this$orderItem = this.getOrderItem();
        final Object other$orderItem = other.getOrderItem();
        if (this$orderItem == null ? other$orderItem != null : !this$orderItem.equals(other$orderItem)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Item;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $Id = this.getId();
        result = result * PRIME + ($Id == null ? 43 : $Id.hashCode());
        final Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $storage = this.getStorage();
        result = result * PRIME + ($storage == null ? 43 : $storage.hashCode());
        final Object $orderItem = this.getOrderItem();
        result = result * PRIME + ($orderItem == null ? 43 : $orderItem.hashCode());
        return result;
    }

    public String toString() {
        return Id.toString();
    }
}
