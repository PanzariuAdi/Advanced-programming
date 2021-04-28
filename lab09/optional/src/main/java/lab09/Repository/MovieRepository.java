package lab09.Repository;
import lab09.Entity.Movie;

public interface MovieRepository {
    Movie getMovieById(int id);
    Movie getMovieByTitle(String title);
    Movie saveMovie(Movie movie);
    void deleteMovie(Movie movie);
}
