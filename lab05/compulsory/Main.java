package lab05;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadPlay();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("My books", "C:/Users/panza/Desktop/catalog.ser");
        var movie = new Movie();
        movie.setName("Star Wars");
        movie.setDirector("George Lucas");
        movie.setId("bestMovie");
        movie.setLocation("C:/Users/panza/Desktop/Facultate/AP/lab05/Compulsory/movie.jpg");

        var book = new Book();
        book.setName("Rocky I");
        book.setAuthor("Steven Spielberg");
        book.setId("bestBook");
        book.setLocation("C:/Users/panza/Desktop/Facultate/AP/lab05/Compulsory/book.pdf");

        var song = new Song();
        song.setName("Cand se lasa seara");
        song.setArtist("Cristian Rizescu");
        song.setId("bestSong");
        song.setLocation("C:/Users/panza/Desktop/Facultate/AP/lab05/Compulsory/song.mp3");

        catalog.addItem(movie);
        catalog.addItem(book);
        catalog.addItem(song);

        catalog.listItems();

        CatalogUtil.save(catalog);
    }

    private void testLoadPlay() throws IOException {
        Catalog catalog = CatalogUtil.load("C:/Users/panza/Desktop/catalog.ser");
        CatalogUtil.play(catalog.findById("bestMovie"));
    }
}
