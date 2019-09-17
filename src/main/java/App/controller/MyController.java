package App.controller;

import App.domain.Climber;
import App.domain.Route;
import App.services.RouteServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import App.services.ClimberServices;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    ClimberServices climberServices;
    @Autowired
    RouteServices routeServices;

    @RequestMapping("/showClimbers")
    public List<Climber> findClimber() {
        Logger logger = LoggerFactory.getLogger(LoggingController.class);
        logger.info("Find all climber");
        return climberServices.findAll();
    }

    @RequestMapping("/route")
    public List<Route> findRoute(){
        return routeServices.findAll();
    }

    @RequestMapping(value="/addClimber/{name}", method = RequestMethod.GET)
    public RedirectView addClimberReq(@PathVariable("name") String name){
        Climber climber = new Climber(name);
        climberServices.addClimber(climber);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/showClimbers");
        return redirectView;
    }
    @PostMapping("/addClimber")
    public String addClimber( @RequestParam("name") String name){
        Climber climber = new Climber(name);
        climberServices.addClimber(climber);
        return "/showClimber";
    }
}
