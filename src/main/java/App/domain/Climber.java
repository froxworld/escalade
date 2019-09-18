package App.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Climber {
    
    @Id // primary key
    @GeneratedValue
    long id;

    String name;

    @OneToMany(mappedBy = "opener") // on dit que la relation est portée par l'attribut opener dans Route
    List<Route> opens;

    @ManyToMany(mappedBy = "climbers") // on dit que la relation est portée par l'attribut climbers de Route
    List<App.domain.Route> realizations;

    @ManyToMany
    @JsonBackReference
    @JoinTable( name = "FRIENDS")
    List<Climber> friends;

    public Climber() {}

    public Climber(String name) {
        this.name = name;
        this.opens = new ArrayList<>();
        this.realizations = new ArrayList<>();
        this.friends = new ArrayList<>();

    }

    public void addFriend(Climber friend) {
        friends.add(friend);
    }

}
