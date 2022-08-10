package com.techelevator.controller;

import com.techelevator.dao.ShowDAO;
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

    private ShowDAO showDao;

    public ShowController (ShowDAO showDao) {this.showDao = showDao;}

    @GetMapping ("/shows/venue/{venueName}")
    List<Show> getShowsByVenue(@PathVariable String venueName) {
        return showDao.getShowsByVenue(venueName);
    }

    @GetMapping ("/shows/bands/{bandName}")
    List<Show> getShowsByBand(@PathVariable String bandName) {
        return showDao.getShowsByBand(bandName);
    }
}
