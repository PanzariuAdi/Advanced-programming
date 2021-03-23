package lab05;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
           try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
            } catch (IOException e) {
               e.printStackTrace();
           }
    }

    public static Catalog load(String path) {
        Catalog catalog = new Catalog("test", path);
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fis);
            catalog = (Catalog) in.readObject();
            in.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static void play(Item item) throws IOException {
        try {
            Desktop desktop = Desktop.getDesktop();
            System.out.println(item.getLocation());
            desktop.browse(URI.create(item.getLocation()));
           // desktop.open(new File(item.getLocation()));
        } catch (Exception e) {
            System.out.println("Itemul nu exista sau nu are o cale valida !");
        }
    }

}