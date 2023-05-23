package fit.johann.Persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Johann Arfmann knübel und Karsten Hölscher
 * Klasse stellt die Verbindung zur Datenbank her
 */
public class PersistenceManager {
    // Name der Datenbank
    private static final String PU_NAME = "BattleshipsDB";
    // Verbindung zur Datenbank
    private static final EntityManagerFactory emFactory;
    static {emFactory = Persistence.createEntityManagerFactory(PU_NAME);}
    // Manager der Objekte auf der Datenbank 
    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
}
