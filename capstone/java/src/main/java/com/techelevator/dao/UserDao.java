package com.techelevator.dao;

import com.techelevator.model.Band;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role, String userEmail);

    List<User> getFollowersByBand(int bandId);

    boolean followBand(String bandName); //maybe void??
    boolean unfollowBand(String bandName); //maybe void??
}
