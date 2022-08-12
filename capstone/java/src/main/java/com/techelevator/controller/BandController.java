package com.techelevator.controller;


import com.techelevator.dao.BandDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Band;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class BandController {

    private BandDao bandDao;
    private UserDao userDao;

    public BandController(BandDao bandDao) {
        this.bandDao = bandDao;
    }

    @GetMapping("/bands")
    public List<Band> getAllBands() {
        return bandDao.getAllBands();
    }

    @GetMapping("/bands/{bandId}")
    public Band getBandsById(@PathVariable int bandId) {
    return bandDao.getBandById(bandId);
}

    @GetMapping("/bands/genres/{genreId}")
    public List<Band> getBandsByGenre(@PathVariable int genreId) {
    return bandDao.getBandsByGenre(genreId);
    }

    @GetMapping("/bands/shows/{showId}")
    public List<Band> getBandsByShow(@PathVariable int showId) {
        return bandDao.getBandsByShow(showId);
    }

    // above this line is 100% confirmed to work in Postman, below is untested

    @GetMapping("/bands/{bandId}/{genreId}")
    public List<Band> getBandsByIdAndGenre(@PathVariable int bandId, @PathVariable int genreId) {
        return bandDao.getBandsByIdAndGenre(bandId, genreId);
    }

    @PostMapping("/bands/newBand")
    boolean createBand(@RequestBody Band newBand, Principal user) {
        int managerId = userDao.findIdByUsername(user.getName());
        return bandDao.createBand(newBand, managerId);
    }

    @PutMapping("/bands/{bandId}")
    public boolean updateBand(@RequestBody Band bandToUpdate, Principal user, @PathVariable int bandId) {
        int currentManagerId = userDao.findIdByUsername(user.getName());
        if (currentManagerId == bandToUpdate.getMgrId()) {
            return bandDao.updateBand(bandToUpdate, bandId);
        } else {
            return false;
        }
    }

    @DeleteMapping("/bands/{bandId}")
    public boolean deleteBand(Band bandToDelete, Principal user, @PathVariable int bandId) {
        int currentManagerId = userDao.findIdByUsername(user.getName());
        if (currentManagerId == bandToDelete.getMgrId()) {
            return bandDao.deleteBand(bandToDelete, bandId);
        } else {
            return false;
        }

    }

}
