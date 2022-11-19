package products;

import jakarta.persistence.*;

@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Integer stock;

    @OneToOne
    @MapsId
    @JoinColumn(name = "Id")
    private Item item;

    public Storage() {
    }

    public void increment() {
        stock += 1;
    }

    public void decrement() {
        if (stock != 0) {
            stock -= 1;
        }
    }

    public Long getId() {
        return this.Id;
    }

    public Integer getStock() {
        return this.stock;
    }

    public Item getItem() {
        return this.item;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Storage)) return false;
        final Storage other = (Storage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$Id = this.getId();
        final Object other$Id = other.getId();
        if (this$Id == null ? other$Id != null : !this$Id.equals(other$Id)) return false;
        final Object this$stock = this.getStock();
        final Object other$stock = other.getStock();
        if (this$stock == null ? other$stock != null : !this$stock.equals(other$stock)) return false;
        final Object this$item = this.getItem();
        final Object other$item = other.getItem();
        if (this$item == null ? other$item != null : !this$item.equals(other$item)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Storage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $Id = this.getId();
        result = result * PRIME + ($Id == null ? 43 : $Id.hashCode());
        final Object $stock = this.getStock();
        result = result * PRIME + ($stock == null ? 43 : $stock.hashCode());
        final Object $item = this.getItem();
        result = result * PRIME + ($item == null ? 43 : $item.hashCode());
        return result;
    }

    public String toString() {
        return Id.toString();
    }

//    public Storage getById(Long id) {
//        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
//            return session.get(Storage.class, id);
//        }
//    }

//    public Integer getById(Long id) {
//        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
//            return session.get(Storage.class, id).getStock();
//        }
//    }
//
//    public List<Storage> getStorage() {
//        try (Session session = Hibernate.getInstance().getSessions().openSession()) {
//            JpaCriteriaQuery<Storage> jpaCriteriaQuery = session
//                    .getCriteriaBuilder()
//                    .createQuery(Storage.class);
//            jpaCriteriaQuery.from(Storage.class);
//
//            TypedQuery<Storage> typedQuery = session.createQuery(jpaCriteriaQuery);
//            return typedQuery.getResultList();
//        }
//    }
}
