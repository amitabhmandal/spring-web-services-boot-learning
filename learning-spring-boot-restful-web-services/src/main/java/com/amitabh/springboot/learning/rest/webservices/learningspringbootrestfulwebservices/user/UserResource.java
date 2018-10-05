package com.amitabh.springboot.learning.rest.webservices.learningspringbootrestfulwebservices.user;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    public UserResource() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findAll(@PathVariable int id) {
        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

    }

    @GetMapping("/age")
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {

        if (yearOfBirth > 2018) {
            return new ResponseEntity<>("Year of birth cannot be in the future", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Your age is " + yearOfBirth, HttpStatus.OK);
    }

}
