package lab05;

import java.awt.*;
import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream((catalog.getPath())))) {
            oos.writeObject(catalog);
        }
    }

    public static void load (String path) throws InvalidCatalogException {
        try  {
            File file = new File(path);
            if(!(file.exists())) throw new MyException("Path invalid!");
            Desktop.getDesktop().open(file);
        } catch (MyException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void play(Item item) throws IOException{
        try {
            File file = new File(item.getLocation());
            if(!(file.exists())) {
                throw new MyException("Path invalid");
            }
            Desktop.getDesktop().open(file);
        } catch (MyException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
    }
}
