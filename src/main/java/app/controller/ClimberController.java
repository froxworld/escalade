package app.controller;

import app.domain.Climber;
import app.services.RouteServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.services.ClimberServices;

import java.util.List;

@RestController
@Api(value = "climber", tags = {"Operations on climber"})
public class ClimberController {
    Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @Autowired
    ClimberServices climberServices;
    @Autowired
    RouteServices routeServices;


    @ApiOperation(value = "View a list of climbers", response = List.class)
    @GetMapping("/climbers")
    public List<Climber> findClimber() {
        logger.info("Find all climber");
        return climberServices.findAll();
    }


    @ApiOperation(value = "Show all friends of user", response = List.class)
    @GetMapping("/friends")
    public List<Climber> findFriends( @RequestParam("name") String name){
        return climberServices.getAllFriends(name);
    }

    @ApiOperation(value = "Add friend to user")
    @PostMapping("/friend")
    public Long addFriend(@RequestParam("user") String name, @RequestParam("friend") String friend){
        return climberServices.addFriend(name, friend);
    }

    @ApiOperation(value = "Add new climber")
    @PostMapping("/climber")
    public String addClimber( @RequestParam("name") String name){
        Climber climber = new Climber(name);
        climberServices.addClimber(climber);
        return "/showClimber";
    }

    @ApiOperation(value = "Remove climber")
    @DeleteMapping("/climber")
    public void deleteClimber(@RequestParam("climber") long id){
        climberServices.removeClimber(id);
    }
}
