package lab05;

public class ListCommand implements Command{
    public static void listItems(Catalog catalog) {
        catalog.getItems().forEach(item -> System.out.println("Name : " + item.getName()));
    }
}
