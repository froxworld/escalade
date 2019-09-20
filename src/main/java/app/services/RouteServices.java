package app.services;

import app.domain.Route;
import app.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServices {
    @Autowired
    RouteRepository repository;


    public List<Route> findAll() {

        return (List<Route>) repository.findAll();
    }
}
