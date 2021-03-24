package lab05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand implements Command{

    public static Catalog loadCatalog(String path) {
        Catalog catalog = new Catalog("test", path);
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fis)){
            catalog = (Catalog) in.readObject();
        } catch (Exception e) {
            System.out.println("[Exception] File not found !");
        }
        return catalog;
    }
}