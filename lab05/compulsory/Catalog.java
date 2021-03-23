package lab05;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public void addItem(Item item) { this.items.add(item); }
    public void listItems() {
        items.forEach(i -> System.out.println(i.getName()));
    }

    public Item findById(String id) {
        return items.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}