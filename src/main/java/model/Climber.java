package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Climber {
    int id;
    String name;
    List<Route> opens;
    List<Route> realizations;
    List<Climber> friends;


    public Climber() {}

    public Climber(String name) {
        this.name = name;
        this.opens = new ArrayList<>();
        this.realizations = new ArrayList<>();
        this.friends = new ArrayList<>();

    }

    @Id // primary key
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "opener") // on dit que la relation est portée par l'attribut opener dans Route
    public List<Route> getOpens() {
        return opens;
    }

    public void setOpens(List<Route> opens) {
        this.opens = opens;
    }

    @ManyToMany(mappedBy = "climbers") // on dit que la relation est portée par l'attribut climbers de Route
    public List<Route> getRealizations() {
        return realizations;
    }

    public void setRealizations(List<Route> realizations) {
        this.realizations = realizations;
    }

    @ManyToMany
    @JoinTable( name = "FRIENDS")
    public List<Climber> getFriends() {
        return friends;
    }

    public void setFriends(List<Climber> friends) {
        this.friends = friends;
    }

    public void addFriends(Climber friend) {
        friends.add(friend);
    }
}
