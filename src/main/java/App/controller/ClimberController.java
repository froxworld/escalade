package App.controller;

import App.domain.Climber;
import App.domain.Route;
import App.services.RouteServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import App.services.ClimberServices;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@Api(value = "climber", description = "Operations on climber")
public class ClimberController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    ClimberServices climberServices;
    @Autowired
    RouteServices routeServices;


    @ApiOperation(value = "View a list of climbers", response = List.class)
    @GetMapping("/showClimbers")
    public List<Climber> findClimber() {
        logger.info("Find all climber");
        return climberServices.findAll();
    }



    @GetMapping("/showFriendsOf{name}")
    public List<Climber> findFriends( @PathVariable("name") String name){
        return climberServices.getAllFriends(name);
    }

    @PostMapping("/addFriendTo{name}")
    public boolean addFriend(@PathVariable String name, @RequestParam("friend") String friend){
        Climber climber = climberServices.findByName(name);
        climber.addFriend(climberServices.findByName(friend));
        climberServices.addClimber(climber);
        return true;
    }

/*    @RequestMapping(value="/addClimber/{name}", method = RequestMethod.GET)
    public RedirectView addClimberReq(@PathVariable("name") String name){
        Climber climber = new Climber(name);
        climberServices.addClimber(climber);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/showClimbers");
        return redirectView;
    }*/
    @PostMapping("/addClimber")
    public String addClimber( @RequestParam("name") String name){
        Climber climber = new Climber(name);
        climberServices.addClimber(climber);
        return "/showClimber";
    }
}
