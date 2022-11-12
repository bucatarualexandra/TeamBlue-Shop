import products.Product;
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

//        utils.Hibernate.getInstance().insertProduct(product1, product2, product3);
//        System.out.println(utils.Hibernate.getInstance().getProductById(1));
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("TV");
        product1.setDescription("4k");
        product1.setPrice(2000.0);
        Hibernate.getInstance().update(product1);
//       utils.Hibernate.getInstance().deleteProductById(52);
        System.out.println(Hibernate.getInstance().getProducts());


    }
}

