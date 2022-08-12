package com.techelevator.controller;


import com.techelevator.dao.ShowDao;
import com.techelevator.model.Show;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class ShowController {

    private ShowDao showDao;

    public ShowController (ShowDao showDao) {this.showDao = showDao;}

    @GetMapping ("/shows/venue/{venueId}")
    List<Show> getShowsByVenue(@PathVariable int venueId) {
        return showDao.getShowsByVenue(venueId);
    }

    @GetMapping ("/shows/bands/{bandId}")
    List<Show> getShowsByBand(@PathVariable int bandId) {
        return showDao.getShowsByBand(bandId);
    }
}
