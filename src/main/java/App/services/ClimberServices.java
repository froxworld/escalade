package App.services;

import App.domain.Climber;
import App.repository.ClimberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClimberServices {
    @Autowired
    ClimberRepository repository;

    public List<Climber> findAll() {

        return (List<Climber>) repository.findAll();
    }

    public void addClimber(Climber climber) {
        repository.save(climber);
    }

    public List<Climber> getAllFriends(String climber) {
        return repository.findFriendsByName(climber);
    }

    public Climber findByName(String name) {
        return repository.findByName(name);
    }
}
