package lab09.Repository.DAO;

import lab09.Entity.Movie;
import lab09.JDBC.DatabaseConnection;
import lab09.Repository.MovieRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieController implements MovieRepository {
    private static int id = 1;
//    private MovieController() {}

    @Override
    public Movie getMovieById(int id) {
        Movie movie = new Movie();
        try {
            Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement();
            String command = "SELECT * FROM movies WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(command);
            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
                movie.setId(rs.getInt(1));
                movie.setTitle(rs.getString(2));
                movie.setReleaseYear(rs.getInt(3));
                movie.setDuration(rs.getInt(4));
                movie.setScore(rs.getInt(5));
            }
        } catch (SQLException throwable) {
            System.out.println("Movie Controller find SQL Exception ");
        }
        return movie;
    }

    @Override
    public Movie getMovieByTitle(String title) {
        return null;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return null;
    }

    @Override
    public void deleteMovie(Movie movie) {

    }
}
