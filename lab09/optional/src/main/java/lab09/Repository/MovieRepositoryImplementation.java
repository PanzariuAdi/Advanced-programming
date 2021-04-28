package lab09.Repository;

import lab09.Entity.Movie;
import lab09.Util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovieRepositoryImplementation implements MovieRepository {
    private final EntityManager entityManager = PersistenceUtil.getInstance().getENTITY_MANAGER_FACTORY().createEntityManager();

    @Override
    public Movie getMovieById(int id) {
        return entityManager.find(Movie.class, id);
    }

    @Override
    public Movie getMovieByTitle(String title) {
        TypedQuery<Movie> tq = entityManager.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class);
        tq.setParameter("title", title);
        return tq.getSingleResult();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        entityManager.persist(movie);
        return movie;
    }

    @Override
    public void deleteMovie(Movie movie) {
        if (entityManager.contains(movie)) {
            entityManager.remove(movie);
        } else {
            entityManager.merge(movie);
        }
    }
}
