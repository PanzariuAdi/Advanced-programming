package lab09;

import lab09.Entity.Movie;

import javax.persistence.*;

public class TestSystem {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("lab09");

    public static void main(String[] args) {
        getMovie(666);

        ENTITY_MANAGER_FACTORY.close();
    }

    public static void getMovie(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT m Movie m WHERE  m.id = :movieID";

        TypedQuery<Movie> tq = em.createQuery(query, Movie.class);
        tq.setParameter("movieID", id);
        Movie movie = null;
        try {
            movie = tq.getSingleResult();
            System.out.println(movie.getTitle() + " " + movie.getDuration());
        } catch (NoResultException ex) {
            System.out.println();
        } finally {
            em.close();
        }
    }
}
