package jpa;

import model.Climber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

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

            Climber c1 = new Climber("Luc");
            Climber c2 = new Climber("Fa");
            Climber c3 = new Climber("Adri");
            manager.persist(c1);
            manager.persist(c2);
            manager.persist(c3);


            c1.addFriends(c2);
            c3.addFriends(c2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

}
