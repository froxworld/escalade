package app.services;

import app.domain.Climber;
import app.repository.ClimberRepository;
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

    public Long addFriend(String name, String friend) {
        Climber climber = findByName(name);
        Climber climberFriend = findByName(friend);
        climber.addFriend(climberFriend);
        addClimber(climber);
        return climberFriend.getId();
    }

    public void removeClimber(long id) {
        repository.deleteById(id);
    }
}
