package lab09.Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil instance = null;
    private EntityManagerFactory ENTITY_MANAGER_FACTORY;

    private PersistenceUtil() {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("oracle");
    }

    public static PersistenceUtil getInstance() {
        if (instance == null)
            instance = new PersistenceUtil();
        return instance;
    }

    public EntityManagerFactory getENTITY_MANAGER_FACTORY() {
        return ENTITY_MANAGER_FACTORY;
    }
}
