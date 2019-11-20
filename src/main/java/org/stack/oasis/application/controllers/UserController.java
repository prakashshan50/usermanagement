package org.stack.oasis.application.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stack.oasis.application.dto.CreateUserDto;
import org.stack.oasis.application.model.Response;
import org.stack.oasis.application.model.User;
import org.stack.oasis.application.service.UserService;

import com.google.gson.Gson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
    private static Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping(path = "/register")
    public ResponseEntity<Response> createUser(@Validated @RequestBody CreateUserDto userDto) {    	
    	User savedUser = userService.save(userDto);
        Response response = new Response();
        response.setResponse("Success");
        response.setStatus("200");
        String gString = new Gson().toJson(savedUser, User.class);
        logger.debug("User Registered Successfully==>" + gString);
        return ResponseEntity.ok(response);
    }
    @PostMapping(path = "/activate/{userName}")
    public ResponseEntity<String> activateUser(@PathVariable String userName) {
    	Optional<User> userOpt=userService.findByUserName(userName);
    	User user =userOpt.get();
    	if(user.getStatus().equals("deactivated")) {
    		user.setStatus("activated");
    	}
    	User activatedUser = userService.activateUser(user);
        String responseStr = new Gson().toJson(activatedUser, User.class);
        logger.debug("User Activated Successfully==>" + responseStr);
        return ResponseEntity.ok(responseStr);
    }
    @GetMapping(path = "/get/{userName}")
    public ResponseEntity<User> get(@PathVariable String userName) {
    	Optional<User> userOpt=userService.findByUserName(userName);
    	User user =userOpt.get();
    	 String gString = new Gson().toJson(user, User.class);
         logger.debug("Current User Details==>" + gString);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping(path = "/getall")
    public ResponseEntity<List<User>> getUsers() {
    	List list=userService.findAll();
        logger.debug("All User Details==>" , list);
        return ResponseEntity.ok(userService.findAll());

    }
}
