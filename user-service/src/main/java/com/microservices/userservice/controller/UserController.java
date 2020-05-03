package com.microservices.userservice.controller;

import com.microservices.userservice.model.User;
import com.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping (value = "/users")
    private List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping (value = "/users", params = "name")
    private User getUserByName(@RequestParam("name") String userName){
        return userService.getUserByName(userName);
    }

    @GetMapping (value = "/users/{id}")
    private User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping (value = "/users")
    private ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(request.getRequestURI() + "/" + user.getId()));
        userService.saveUser(user);
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }
}
