package lab05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand implements Command{
    public static void saveCatalog(Catalog catalog) {
        try (FileOutputStream fos = new FileOutputStream(catalog.getName());
             ObjectOutputStream os = new ObjectOutputStream(fos)) {
                os.writeObject(catalog);
                os.flush();
        } catch (IOException e) {
            System.out.println("[Exception] salvare");
        }
    }
}
