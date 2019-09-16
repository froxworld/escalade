package App.services;

import App.domain.Climber;
import App.domain.Route;
import App.dto.ClimberRepository;
import App.dto.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServices {
    @Autowired
    private RouteRepository repository;

    public List<Route> findAll() {

        List<Route> routes = (List<Route>) repository.findAll();
        return routes;
    }
}
