package lab05;

import java.util.List;

public class AddCommand implements Command{
    public static void addItem(Catalog catalog, Item item) {
        List<Item> items = catalog.getItems();
        items.add(item);
        catalog.setItems(items);
    }
}
