package com.amitabh.springboot.learning.rest.webservices.learningspringbootrestfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "abc", new Date()));
        users.add(new User(2, "pqr", new Date()));
        users.add(new User(3, "xyz", new Date()));
    }

    public UserDaoService() {
        // TODO Auto-generated constructor stub
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {

        List<User> existingUser = users;
        int identificationNumber = 0;
        for (User usr : users) {
            identificationNumber = usr.getId();
        }
        User temp = new User(identificationNumber + 1, user.getName(), new Date());
        users.add(temp);
        return temp;
    }

    public User findOne(int id) {
        return users.get(id);
    }

}
