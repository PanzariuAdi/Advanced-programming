package lab09.Repository;

import lab09.Entity.Actor;

public interface ActorRepository {
    Actor getActorById(int id);
    Actor getActorByName(String name);
    Actor saveActor(Actor actor);
    void deleteActor(Actor actor);
}
