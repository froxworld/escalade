package app.repository;

import app.domain.Climber;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClimberRepository extends CrudRepository<Climber, Long> {

    Climber findById(long i);
    Climber findByName(String name);

    @Query("SELECT c.friends FROM Climber c where c.name = :name")
    List<Climber> findFriendsByName(String name);
    void deleteByName(String name);

}
