package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDao userDao;

    public UserController (UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/bands/{bandId}/followers")
    public List<User> getFollowersByBand (@PathVariable int bandID) {
        return userDao.getFollowersByBand(bandID);
    }

}
