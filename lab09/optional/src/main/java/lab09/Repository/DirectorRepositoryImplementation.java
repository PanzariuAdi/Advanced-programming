package lab09.Repository;

import lab09.Entity.Director;
import lab09.Util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DirectorRepositoryImplementation implements DirectorRepository{
    private final EntityManager entityManager = PersistenceUtil.getInstance().getENTITY_MANAGER_FACTORY().createEntityManager();


    @Override
    public Director getDirectorById(int id) {
        return entityManager.find(Director.class, id);
    }

    @Override
    public Director getDirectorByName(String name) {
        TypedQuery<Director> tq = entityManager.createQuery("SELECT d FROM Director d WHERE d.nume = :name", Director.class);
        tq.setParameter("name", name);
        return tq.getSingleResult();
    }

    @Override
    public Director saveDirector(Director director) {
        entityManager.persist(director);
        return director;
    }

    @Override
    public void deleteDirector(Director director) {
        if (entityManager.contains(director)) {
            entityManager.remove(director);
        } else {
            entityManager.merge(director);
        }
    }
}
