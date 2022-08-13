package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

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
    public List<User> getFollowersByBand (@PathVariable int bandId) {
        return userDao.getFollowersByBand(bandId);
    }

    @PutMapping("/bands/{bandId}/follow")
    public void followBand (@RequestBody int userId, @RequestBody @PathVariable int bandId) {userDao.followBand(userId, bandId);}

    @DeleteMapping("/bands/{bandId}/unfollow")
    public void unfollowBand(int userId, @PathVariable int bandId) {userDao.unfollowBand(userId, bandId);}

}
