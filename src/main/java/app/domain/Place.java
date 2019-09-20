package app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Place {
    @NonNull
    String name;

    @Id // primary key
    @GeneratedValue
    int id;
}
