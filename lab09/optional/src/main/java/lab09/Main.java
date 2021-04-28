package lab09;


import lab09.Entity.Movie;
import lab09.Repository.DAO.MovieController;
import lab09.Repository.MovieRepositoryImplementation;

public class Main {

    public static void main(String[] args) {
        Chart chart = new Chart();
        chart.setName("Top Movies with id between 2 and 150");

        MovieRepositoryImplementation movies = new MovieRepositoryImplementation();
        MovieController movieController = new MovieController();

        Movie movie = new Movie();
        for (int i = 2; i <= 150; i++) {
            movie = movies.getMovieById(i);
            chart.addMovie(movie);
        }

//        chart.showMovies();

        movie = movieController.getMovieById(100);
        System.out.println(movie.getTitle());
    }

}
