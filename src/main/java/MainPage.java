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
import java.util.stream.Collectors;

public class MainPage {
    static OrderItem orderItem = new OrderItem();
    static ProductManagement productManagement = new ProductManagement();


    public static void main(String[] args) {
//        Storage storageTv = new Storage();
//        storageTv.setStock(8);
//
//        Storage storagePhone = new Storage();
//        storagePhone.setStock(2);
//
//        Storage storageFridge = new Storage();
//        storageFridge.setStock(3);
//
//        Item tv = new Item();
//        tv.setProductName("TV");
//        tv.setDescription("8k");
//        tv.setPrice(2500.0);
//        tv.setOrderItem(new ArrayList<>());
//        tv.setStorage(storageTv);
//
//        storageTv.setItem(tv);
//
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

//        ProductManagement productManagement = new ProductManagement();
//        productManagement.insert(tv);
//        productManagement.insert(phone);
//        productManagement.insert(fridge);
//        productManagement.update(tv);
//        System.out.println(productManagement.getById(102));
//        productManagement.deleteById(152L);
//        System.out.println(productManagement.getItems());
//
//        User user2 = new User();
//        user2.setUserName("Alexandra");
//        user2.setAddress("Cluj");
//        user2.setEmail("Alexandra  email etc");
//
//        UsersManagement usersManagement = new UsersManagement();
//        usersManagement.insert(user2);
//        usersManagement.getItems();
//        System.out.println("hello");

//        OrderManagement orderManagement = new OrderManagement();
//        orderManagement.getById();
//
//
//        OrderItem orderItem = new OrderItem();
//        if (storageTv.getStock() >= 1) {
//            orderItem.addItemsToOrder(tv);
//            storageTv.decrement();
//        } else {
//            System.out.println("Sorry, item not in store");
//        }
        while (true) {
            showMenu();
        }
    }


    public static void showMenu() {
        System.out.println("0. Select user");
        System.out.println("1. Show items");
        System.out.println("2. Add item");
        System.out.println("3. Remove item");
        System.out.println("3. Buy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your input: ");
        String result = scanner.nextLine();

        switch (result) {
            case "0":
                logIn();

                break;
            case "1":
                System.out.println("These are the available products: ");
                showItems();
                break;
            case "2":
                addItem();
                break;
            case "3":
                removeItem();
                break;
            case "4":
                registerOrder();
                break;
            default:
                System.out.println("Invalid option");
        }

    }

    public static void logIn() {
        Scanner scanner = new Scanner(System.in);
        UsersManagement usersManagement = new UsersManagement();
        usersManagement.getItems().forEach((user) -> System.out.println(user.getUserName()));
        System.out.println("Choose username: ");
        String userName = scanner.nextLine();
        User user = usersManagement.getItems().stream()
                .filter((usr) -> usr.getUserName().equalsIgnoreCase(userName))
                .toList()
                .get(0);
        System.out.println(user);
//        orderItem.setUser(user);
    }

    public static void showItems() {
        productManagement.getItems().forEach((item) -> System.out.println(item.getId()
                + " " + item.getProductName()));
    }

    public static void addItem() {
        Storage storage = new Storage();
        System.out.println("Choose an item you want to add to your cart: ");
        productManagement.getItems().forEach((item) -> System.out.println(item.getId()
                + " " + item.getProductName()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your item id: ");
        String result = scanner.nextLine();
        if ("1".equals(result)) {
            orderItem.addItemsToOrder(productManagement.getById(1L));
            storage.getById(1L);
            storage.decrement();
        } else if ("2".equals(result)) {
            orderItem.addItemsToOrder(productManagement.getById(2L));
            storage.getById(2L);
            storage.decrement();
        } else if ("3".equals(result)) {
            orderItem.addItemsToOrder(productManagement.getById(3L));
            storage.getById(3L);
            storage.decrement();
        } else {
            System.out.println("Invalid item");
        }
    }

    public static void removeItem() {
        Storage storage = new Storage();
        System.out.println("Choose an item you want to remove from your cart: ");
        productManagement.getItems().forEach((item) -> System.out.println(item.getId()
                + " " + item.getProductName()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your item id: ");
        String result = scanner.nextLine();
        if ("1".equals(result)) {
            orderItem.addItemsToOrder(productManagement.getById(1L));
            storage.getById(1L);
            storage.increment();
        } else if ("2".equals(result)) {
            orderItem.addItemsToOrder(productManagement.getById(2L));
            storage.getById(2L);
            storage.increment();
        } else if ("3".equals(result)) {
            orderItem.addItemsToOrder(productManagement.getById(3L));
            storage.getById(3L);
            storage.increment();
        } else {
            System.out.println("Invalid item");
        }
    }

    public static void registerOrder() {
        OrderManagement orderManagement = new OrderManagement();
        orderManagement.insert(orderItem);
    }
}



