package App.services;

import App.domain.Climber;
import App.dto.ClimberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimberServices {
    @Autowired
    private ClimberRepository repository;

    public List<Climber> findAll() {

        List<Climber> countries = (List<Climber>) repository.findAll();
        return countries;
    }
}
