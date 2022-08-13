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

    @GetMapping("/bands") //WORKING: Postman confirmed
    public List<Band> getAllBands() {
        return bandDao.getAllBands();
    }

    @GetMapping("/bands/{bandId}") //WORKING: Postman confirmed
    public Band getBandById(@PathVariable int bandId) {
    return bandDao.getBandById(bandId);
}

    @GetMapping("bands/search/{bandName}") //WORKING: Postman confirmed
    public List<Band> getBandsByName(@PathVariable String bandName) {return bandDao.getBandsByName(bandName);}

    @GetMapping("/bands/genres/{genreName}") //WORKING: Postman confirmed
    public List<Band> getBandsByGenre(@PathVariable String genreName) {
    return bandDao.getBandsByGenre(genreName);
    }

    @GetMapping("/bands/shows/{showTitle}") //WORKING: Postman confirmed
    public List<Band> getBandsByShow(@PathVariable String showTitle) {
        return bandDao.getBandsByShow(showTitle);
    }

    @GetMapping("/bands/{bandId}/{genreId}") //NOT WORKING: Do we even need??
    public List<Band> getBandsByIdAndGenre(@PathVariable int bandId, @PathVariable int genreId) {
        return bandDao.getBandsByIdAndGenre(bandId, genreId);
    }

    @PostMapping("/bands/newband") //WORKING: Postman confirmed as-is, but add Principal user later.
    Band createBand(@RequestBody Band newBand, Principal user) {
        //int managerId = userDao.findIdByUsername(user.getName());
        return bandDao.createBand(newBand);
    }

    @PutMapping("/bands/{bandId}") //WORKING: Postman confirmed as-is, but add Principal user later.
    public boolean updateBand(@RequestBody Band bandToUpdate, Principal user, @PathVariable int bandId) {
//        int currentManagerId = userDao.findIdByUsername(user.getName());
//        if (currentManagerId == bandToUpdate.getMgrId()) {
            return bandDao.updateBand(bandToUpdate, bandId);
//        } else return false;
    }

    @DeleteMapping("/bands/{bandId}") //WORKING: Postman confirmed as-is, but add Principal user later.
    public boolean deleteBand(Band bandToDelete, Principal user, @PathVariable int bandId) {
//        int currentManagerId = userDao.findIdByUsername(user.getName());
//        if (currentManagerId == bandToDelete.getMgrId()) {
            return bandDao.deleteBand(bandToDelete, bandId);
//        } else {
//            return false;
//        }
    }


}
