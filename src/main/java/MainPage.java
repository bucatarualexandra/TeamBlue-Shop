import products.Item;
import products.ProductManagement;
import products.Storage;
import user.User;
import user.UsersManagement;

import java.util.ArrayList;

public class MainPage {
    public static void main(String[] args) {
        Storage storageTv = new Storage();
        storageTv.setStock(8);

        Storage storagePhone = new Storage();
        storagePhone.setStock(2);

        Storage storageFridge = new Storage();
        storageFridge.setStock(3);

        Item tv = new Item();
        tv.setProductName("TV");
        tv.setDescription("8k");
        tv.setPrice(2500.0);
        tv.setOrderItem(new ArrayList<>());
        tv.setStorage(storageTv);

        storageTv.setItem(tv);

        Item phone = new Item();
        phone.setProductName("Phone");
        phone.setDescription("Smartphone");
        phone.setPrice(1500.0);
        phone.setStorage(storagePhone);

        storagePhone.setItem(phone);

        Item fridge = new Item();
        fridge.setProductName("Fridge");
        fridge.setDescription("Cooler A++");
        fridge.setPrice(3500.0);
        fridge.setStorage(storageFridge);

        storageFridge.setItem(fridge);


//        Product tv = new Product();
//        tv.setId(1);
//        tv.setName("TV");
//        tv.setDescription("4k");
//        tv.setPrice(3000.0);
//
//        Product stove = new Product();
//        stove.setName("Stove");
//        stove.setDescription("Induction stove");
//        stove.setPrice(1500.0);

        ProductManagement productManagement = new ProductManagement();
        productManagement.insert(tv);
        productManagement.insert(phone);
        productManagement.insert(fridge);
//        productManagement.update(tv);
//        System.out.println(productManagement.getById(102));
//        productManagement.deleteById(152L);
//        System.out.println(productManagement.getItems());

        User user1 = new User();
        user1.setUserName("Sorin");
        user1.setAddress("Iasi");
        user1.setEmail("Sorin etc");
//
        UsersManagement usersManagement = new UsersManagement();
        usersManagement.insert(user1);
//        usersManagement.getItems();
        System.out.println("hello");

//        OrderManagement orderManagement = new OrderManagement();
//        orderManagement.getById(1);


    }
}

