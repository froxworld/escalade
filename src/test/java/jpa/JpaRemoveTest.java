package jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaRemoveTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.createQuery("DELETE FROM Climber").executeUpdate();
            manager.createQuery("DELETE FROM Route").executeUpdate();
            manager.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

}


