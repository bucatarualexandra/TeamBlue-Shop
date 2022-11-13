import products.Item;
import products.ProductManagement;
import products.Storage;
import sales.Discount;
import sales.OrderItem;
import sales.OrderManagement;
import user.User;
import user.UsersManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPage {
    public static void showMenu() {
        System.out.println("0. Select user");
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. Buy");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();

        switch (result) {
            case "0":
                UsersManagement usersManagement = new UsersManagement();
                usersManagement.getItems().forEach((user) -> System.out.println(user.getUserName()));
                scanner.next();
            case "1":

            case "2":
            case "3":
            default:
                System.out.println("Invalid option");
        }

    }

    public static void add() {

    }


    public static void main(String[] args) {
//        Storage storageTv = new Storage();
//        storageTv.setStock(8);
//
//        Storage storagePhone = new Storage();
//        storagePhone.setStock(2);
//
//        Storage storageFridge = new Storage();
//        storageFridge.setStock(3);
////
//        Item tv = new Item();
//        tv.setProductName("TV");
//        tv.setDescription("8k");
//        tv.setPrice(2500.0);
//        tv.setOrderItem(new ArrayList<>());
//        tv.setStorage(storageTv);
//
//        storageTv.setItem(tv);
////
//        Item phone = new Item();
//        phone.setProductName("Phone");
//        phone.setDescription("Smartphone");
//        phone.setPrice(1500.0);
//        phone.setStorage(storagePhone);
//
//        storagePhone.setItem(phone);
//
//        Item fridge = new Item();
//        fridge.setProductName("Fridge");
//        fridge.setDescription("Cooler A++");
//        fridge.setPrice(3500.0);
//        fridge.setStorage(storageFridge);
//
//        storageFridge.setItem(fridge);


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

//        ProductManagement productManagement = new ProductManagement();
//        productManagement.insert(tv);
//        productManagement.insert(phone);
//        productManagement.insert(fridge);
//        productManagement.update(tv);
//        System.out.println(productManagement.getById(102));
//        productManagement.deleteById(152L);
//        System.out.println(productManagement.getItems());

//        User user2 = new User();
//        user2.setUserName("Alexandra");
//        user2.setAddress("Cluj");
//        user2.setEmail("Alexandra  email etc");
////
//        UsersManagement usersManagement = new UsersManagement();
//        usersManagement.insert(user2);
//        usersManagement.getItems();
//        System.out.println("hello");
//
////        OrderManagement orderManagement = new OrderManagement();
////        orderManagement.getById(1);
//        OrderItem orderItem = new OrderItem();
//        if (storageTv.getStock() >= 1) {
//            orderItem.addItemsToOrder(tv);
//            storageTv.decrement();
//        } else {
//            System.out.println("Sorry, item not in store");
//        }


    }
}

