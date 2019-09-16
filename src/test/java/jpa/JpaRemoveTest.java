package jpa;


import javax.persistence.*;

public class JpaRemoveTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {

            manager.createQuery("DELETE FROM Route").executeUpdate();
            manager.createQuery("DELETE FROM Climber ").executeUpdate();
            manager.createQuery("DELETE FROM Place ").executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
    }

}


