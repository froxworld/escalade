package App.dto;

import App.domain.Climber;
import org.springframework.data.repository.CrudRepository;

public interface ClimberRepository extends CrudRepository<Climber, Long> {

    Climber findById(long i);
    Climber findByName(String name);
}
