package lab09.Repository;

import lab09.Entity.Actor;
import lab09.Util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ActorRepositoryImplementation implements ActorRepository{

    private final EntityManager entityManager = PersistenceUtil.getInstance().getENTITY_MANAGER_FACTORY().createEntityManager();

    @Override
    public Actor getActorById(int id) {
        return entityManager.find(Actor.class, id);
    }

    @Override
    public Actor getActorByName(String name) {
        TypedQuery<Actor> tq = entityManager.createQuery("SELECT a FROM Actor a WHERE a.nume = :name", Actor.class);
        tq.setParameter("name", name);
        return tq.getSingleResult();
    }

    @Override
    public Actor saveActor(Actor actor) {
        entityManager.persist(actor);
        return actor;
    }

    @Override
    public void deleteActor(Actor actor) {
        if (entityManager.contains(actor)) {
            entityManager.remove(actor);
        } else {
            entityManager.merge(actor);
        }
    }
}
