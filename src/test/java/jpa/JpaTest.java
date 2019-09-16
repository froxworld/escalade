package jpa;

import model.Climber;
import model.Place;
import model.Route;
import model.RouteType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
            //add 3 climbers
            Climber c1 = new Climber("Luc");
            Climber c2 = new Climber("Fa");
            Climber c3 = new Climber("Adri");

            c1.addFriend(c2);
            c3.addFriend(c2);

            List<Climber> l1 = new ArrayList<Climber>();
            l1.add(c1);
            l1.add(c2);
            //add Routes
            String n1 = "les ailes du désir";
            String n2 = "trop belle pour toi";

            Place p1 = new Place("orpierre");
            Place p2 = new Place("ceou");

            float coordLat1 = 1.23654f;
            float coordLong1 = 3.26589f;

            float coordLat2 = 1.23654f;
            float coordLong2 = 3.26589f;

            Calendar cal1 =  Calendar.getInstance();

            Route r1 = new Route(l1, c1, n1, p1, coordLat1, coordLong1, cal1, RouteType.BOULDER);
            Route r2 = new Route(l1, c2, n1, p1, coordLat2, coordLong1, cal1, RouteType.EXTERIOR);
            Route r3 = new Route(l1, c3, n1, p1, coordLat1, coordLong2, cal1, RouteType.INTERIOR);

            manager.persist(c1);
            manager.persist(c2);
            manager.persist(c3);
            manager.persist(p1);
            manager.persist(p2);
            manager.persist(r1);
            manager.persist(r2);
            manager.persist(r3);

            manager.flush();

            c3.removeFriend(c1);
            c1.removeFriend(c2);
            manager.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();
    }

}
