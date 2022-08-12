package com.techelevator.controller;

import com.techelevator.dao.VenueDao;
import com.techelevator.model.Venue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class VenueController {

    VenueDao venueDao;

    public  VenueController (VenueDao venueDao) {this.venueDao = venueDao;}


    @GetMapping ("/venues")
    List<Venue> getAllVenues() {
        return venueDao.getAllVenues();
    }

    @GetMapping("/venues/{venueId}")
    List<Venue> getVenueById(@PathVariable int venueId) {
        return venueDao.getVenueById(venueId);
    }

}
