package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Route {
    int id;


    List<Climber> climbers;
    String name;
    Climber opener;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Climber getOpener() {
        return opener;
    }

    public void setOpener(Climber opener) {
        this.opener = opener;
    }

    @ManyToMany
    @JoinTable( name= "Realizations")
    public List<Climber> getClimbers() {
        return climbers;
    }

    public void setClimbers(List<Climber> climbers) {
        this.climbers = climbers;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
