package lab09.Repository;
import lab09.Entity.Director;

public interface DirectorRepository {
    Director getDirectorById(int id);
    Director getDirectorByName(String name);
    Director saveDirector(Director director);
    void deleteDirector(Director director);
}
