package App.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class Route {
    int id;

//@JsonBackReference
    List<Climber> climbers;
    String name;
    App.domain.Climber opener;
    App.domain.Place place;
    float coordLat;
    float coorLong;
    Calendar timeStamp;


    public Route(List<App.domain.Climber> climbers, App.domain.Climber opener, String name, App.domain.Place place, float coordLat, float coorLong, Calendar timeStamp, RouteType routeType) {
        this.climbers = climbers;
        this.name = name;
        this.opener = opener;
        this.place = place;
        this.coordLat = coordLat;
        this.coorLong = coorLong;
        this.timeStamp = timeStamp;
        this.routeType = routeType;
    }

    App.domain.RouteType routeType;

    public Route() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public App.domain.Climber getOpener() {
        return opener;
    }

    public void setOpener(App.domain.Climber opener) {
        this.opener = opener;
    }

    @ManyToMany
    @JoinTable( name= "Realizations")
    public List<App.domain.Climber> getClimbers() {
        return climbers;
    }

    public void setClimbers(List<App.domain.Climber> climbers) {
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
    public App.domain.RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(App.domain.RouteType routeType) {
        this.routeType = routeType;
    }

    @ManyToOne
    public App.domain.Place getPlace() {
        return place;
    }

    public void setPlace(App.domain.Place place) {
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
