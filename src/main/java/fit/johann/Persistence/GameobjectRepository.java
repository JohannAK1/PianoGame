package fit.johann.Persistence;

import fit.johann.model.battleship.Game;
import fit.johann.model.battleship.Gameobject;
import fit.johann.model.battleship.ShipDataPer;
import jakarta.persistence.EntityManager;

public class GameobjectRepository {
    PersistenceManager pm = new PersistenceManager();

    public void persistGameobject (Gameobject gameobject){
        EntityManager em = pm.getEntityManager();
        em.getTransaction().begin();
        em.persist(gameobject);
        em.getTransaction().commit();
        System.out.println("Works");
    }

    public Gameobject getGameobject(String name){
        EntityManager em = pm.getEntityManager();
        em.getTransaction().begin();
        Gameobject g = em.find(Gameobject.class,name);
        em.getTransaction().commit();
        return g;
    }


    public void persistShipData (ShipDataPer shipData){
        EntityManager em = pm.getEntityManager();
        em.getTransaction().begin();
        em.persist(shipData);
        em.getTransaction().commit();
        System.out.println("Works");
    }

    public ShipDataPer getGameobject(int id){
        EntityManager em = pm.getEntityManager();
        em.getTransaction().begin();
        ShipDataPer g = em.find(ShipDataPer.class,id);
        em.getTransaction().commit();
        return g;
    }
}
