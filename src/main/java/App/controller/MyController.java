package App.controller;

import App.domain.Climber;
import App.domain.Route;
import App.services.RouteServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import App.services.ClimberServices;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    ClimberServices climberServices;
    @Autowired
    RouteServices routeServices;

    @RequestMapping("/showClimber")
    public List<Climber> findClimber() {
        Logger logger = LoggerFactory.getLogger(LoggingController.class);
        logger.info("Find all climber");
        return climberServices.findAll();
    }

    @RequestMapping("/route")
    public List<Route> findRoute(){
        return routeServices.findAll();
    }

    @PostMapping("/addClimber")
    public String addClimber( @RequestParam("name") String name){
        Climber climber = new Climber(name);
        climberServices.addClimber(climber);
        return "/showClimber";
    }
}
