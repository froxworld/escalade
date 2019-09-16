package App.controller;

import App.domain.Climber;
import App.domain.Route;
import App.services.RouteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import App.services.ClimberServices;

import java.util.List;

public class MyController {

    @Autowired
    ClimberServices climberServices;
    @Autowired
    RouteServices routeServices;

    @RequestMapping("/showClimber")
    public List<Climber> findClimber() {
        return climberServices.findAll();
    }

    @RequestMapping("/route")
    public List<Route> findRoute(){
        return routeServices.findAll();
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
