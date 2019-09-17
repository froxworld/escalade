package App.services;

import App.domain.Climber;
import App.dto.ClimberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimberServices {
    private final ClimberRepository repository;

    public ClimberServices(ClimberRepository repository) {
        this.repository = repository;
    }

    public List<Climber> findAll() {

        return (List<Climber>) repository.findAll();
    }

    public void addClimber(Climber climber) {
        repository.save(climber);
    }
}
