package model;

import javax.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class Route {
    int id;


    List<Climber> climbers;
    String name;
    Climber opener;
    Place place;
    float coordLat;
    float coorLong;
    Calendar timeStamp;


    public Route( List<Climber> climbers,Climber opener, String name, Place place, float coordLat, float coorLong, Calendar timeStamp, RouteType routeType) {
        this.climbers = climbers;
        this.name = name;
        this.opener = opener;
        this.place = place;
        this.coordLat = coordLat;
        this.coorLong = coorLong;
        this.timeStamp = timeStamp;
        this.routeType = routeType;
    }

    RouteType routeType;

    public Route() {
    }



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
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    @ManyToOne
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public float getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(float coordLat) {
        this.coordLat = coordLat;
    }

    public float getCoorLong() {
        return coorLong;
    }

    public void setCoorLong(float coorLong) {
        this.coorLong = coorLong;
    }

    @Temporal(TemporalType.DATE)
    public Calendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }
}
