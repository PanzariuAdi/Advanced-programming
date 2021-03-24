package lab05;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCatalogException {
	    String commandLine;
	    boolean loaded = false;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Catalog catalog = null;

        do {
            System.out.println("Commands are : ");
            System.out.println("1 : load");
            System.out.println("2 : save");
            System.out.println("3 : add item");
            System.out.println("4 : list items");
            System.out.println("5 : play");
            System.out.println("6 : exit");
            System.out.print("shell>");
            commandLine = console.readLine();

            if (commandLine.equals("1")) {
                //System.out.println("Path : ");
                //String path = console.readLine();
                String path = "C:/Users/panza/Desktop/catalog.ser";
                catalog = LoadCommand.loadCatalog(path);
                catalog.setPath(path);
                loaded = true;
                System.out.println("\n\nA fost incarcat un catalog !\n\n");

            } else if (commandLine.equals("2") && loaded) {
                SaveCommand.saveCatalog(catalog);
                loaded = false;
                System.out.println("\n\nSalvat cu succes !\n\n");

            } else if (commandLine.equals("3") && loaded) {
                Item item = new Item();
                System.out.println("Item name : ");
                item.setName(console.readLine());
                System.out.println("Item ID : ");
                item.setId(console.readLine());
                System.out.println("Item location : ");
                item.setLocation(console.readLine());
                AddCommand.addItem(catalog, item);
                System.out.println("\n");

            } else if (commandLine.equals("4") && loaded) {
                ListCommand.listItems(catalog);

            } else if (commandLine.equals("5") && loaded) {
                System.out.println("ID : ");
                PlayCommand.playItem(catalog, console.readLine());
            }

        } while (!commandLine.equals("6"));
    }
}