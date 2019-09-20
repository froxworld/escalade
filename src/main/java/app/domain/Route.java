package app.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Route {

    @Id
    @GeneratedValue
    int id;

    @ManyToMany
    @JoinTable(name = "Realizations")
    @NonNull
    List<Climber> climbers;
    @NonNull
    String name;

    @ManyToOne
    @NonNull
    Climber opener;

    @ManyToOne
    @NonNull
    Place place;

    @NonNull
    float coordLat;

    @NonNull
    float coorLong;

    @Temporal(TemporalType.DATE)
    @NonNull
    Calendar timeStamp;

    @Enumerated(EnumType.STRING)
    RouteType routeType;


}
