package com.techelevator.controller;


import com.techelevator.dao.BandDao;
import com.techelevator.model.Band;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class BandController {

    private BandDao bandDao;

    public BandController(BandDao bandDao) {
        this.bandDao = bandDao;
    }

    @GetMapping("/bands")
    public List<Band> getAllBands() {
        return bandDao.getAllBands();
    }

    @GetMapping ("/bands/{bandId}")
    public Band getBandsById(@PathVariable int bandId) {
    return bandDao.getBandById(bandId);
}

    @GetMapping ("/bands/genres/{genreId}")
    public List<Band> getBandsByGenre(@PathVariable int genreId) {
    return bandDao.getBandsByGenre(genreId);
    }

    @GetMapping("/bands/shows/{showId}")
    public List<Band> getBandsByShow(@PathVariable int showId) {
        return bandDao.getBandsByShow(showId);
    }

    // above this line is 100% confirmed to work in Postman, below is untested

    @GetMapping ("/bands/{bandId}/{genreId}")
    public List<Band> getBandsByIdAndGenre(@PathVariable int bandId, @PathVariable int genreId) {
    return bandDao.getBandsByIdAndGenre(bandId, genreId);
    }

    @PostMapping ("/bands/newBand")
    Band createBand(@Valid @RequestBody Band newBand, Integer MgrId){
    return bandDao.createBand(newBand, MgrId);
    }

    @DeleteMapping ("/bands/{bandId}")
    public boolean deleteBand(@PathVariable int bandId) {
    return bandDao.deleteBand(bandId);
    }

    @PutMapping("/bands/{bandId}")  // takes in a bandID but provides a mgrId???
    public boolean updateBand(@Valid @RequestBody Band updatedBand, @PathVariable int mgrId) {
        if (mgrId == updatedBand.getMgrId()) {
            return bandDao.updateBand(updatedBand, mgrId);
        } else return false;
    }


}
