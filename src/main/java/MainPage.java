import products.Product;
import products.ProductManagement;
import users.User;
import users.UsersManagement;
import utils.Hibernate;

public class MainPage {
    public static void main(String[] args) {
//        Product product1 = new Product();
//        product1.setName("TV");
//        product1.setDescription("8k");
//        product1.setPrice(2500.0);
//
//        Product product2 = new Product();
//        product2.setName("Phone");
//        product2.setDescription("Smartphone");
//        product2.setPrice(1500.0);
//
//        Product product3 = new Product();
//        product3.setName("Fridge");
//        product3.setDescription("Cooler A++");
//        product3.setPrice(3500.0);


//        Product product1 = new Product();
//        product1.setId(1);
//        product1.setName("TV");
//        product1.setDescription("4k");
//        product1.setPrice(3000.0);
//
//        Product product4 = new Product();
//        product4.setName("Stove");
//        product4.setDescription("Induction stove");
//        product4.setPrice(1500.0);

//        ProductManagement productManagement = new ProductManagement();
//        productManagement.update(product1);
//        productManagement.insert(product4);
//        System.out.println(productManagement.getById(102));
//        productManagement.deleteById(102);
//        System.out.println(productManagement.getItems());

        User user1 = new User();
        user1.setUserName("Sorin");
        user1.setAddress("Iasi");
        user1.setEmail("Sorin etc");

        UsersManagement usersManagement = new UsersManagement();
        usersManagement.insert(user1);
        usersManagement.getItems();
    }
}

