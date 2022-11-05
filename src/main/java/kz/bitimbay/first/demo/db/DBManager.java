package kz.bitimbay.first.demo.db;

import kz.bitimbay.first.demo.models.Item;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static List<Item> itemsList = new ArrayList<>();

    static {
        itemsList.add(new Item(1L, "Macbook Pro 2020", "8 GB RAM 256 GB SSD Intel Core i7", 1499.99));
        itemsList.add(new Item(2L, "ASUS TUF GAMING", "16 GB RAM 512 GB SSD AMD Ryzen 5", 999.99));
        itemsList.add(new Item(3L, "Apple IPhone 12 Pro", "6 GB RAM 128 GB MEMORY Super Retina XDR Display", 1099.99));
        itemsList.add(new Item(4L, "XIAOMI Redmi Note 8", "6 GB RAM 64 GB MEMORY Android 9", 199.99));
        itemsList.add(new Item(5L, "XIAOMI Redmi Note 10", "8 GB RAM 1238 GB MEMORY Android 11", 299.99));
        itemsList.add(new Item(6L, "MSI Prestige 15", "Intel Core i7 1024 GB MEMORY 32 GB RAM", 1999.99));
    }

    static Long id = 7L;
    public static List<Item> getItemsList() {
        return itemsList;
    }


    public static void addItem(Item item) {
        item.setId(id);
        itemsList.add(item);
        id++;
    }

    public static String getDetails(Long id) {
        for (Item it : itemsList) {
            if (id == it.getId()) {
                return it.getName() + it.getDescription() + it.getPrice();
            }
        }
        return null;
    }
}

