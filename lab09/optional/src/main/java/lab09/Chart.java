package lab09;

import lab09.Entity.Movie;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class Chart {
    private String name;
    private final String creation_date;
    private TreeSet<Movie> movieTop = new TreeSet<Movie>();

    public Chart() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.creation_date = formatter.format(date.getTime());
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public String getCreation_date() { return creation_date; }
    public TreeSet<Movie> getMovieTop() { return movieTop; }
    public void setMovieTop(TreeSet<Movie> movieTop) { this.movieTop = movieTop; }

    public void addMovie(Movie movie) {
        this.movieTop.add(movie);
    }

    public void showMovies() {
        this.movieTop.forEach(movie -> System.out.println(movie.getTitle() + " " + movie.getScore()));
    }
}
