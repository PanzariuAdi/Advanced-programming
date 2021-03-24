package lab05;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class PlayCommand implements Command{
    public static void playItem(Catalog catalog, String id) {
        Item item = catalog.getItems().stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(URI.create(item.getLocation()));
            // desktop.open(new File(item.getLocation()));
        } catch (Exception e) {
            System.out.println("[Exception] Itemul nu exista sau nu are o cale valida !");
        }
    }
}
