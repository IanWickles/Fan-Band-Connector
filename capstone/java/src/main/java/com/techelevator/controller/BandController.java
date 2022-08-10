package com.techelevator.controller;

import com.techelevator.dao.BandDAO;
import com.techelevator.model.Band;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class BandController {

private BandDAO bandDAO;

public BandController (BandDAO bandDAO) {this.bandDAO = bandDAO;}

    @GetMapping ("/bands")
    public List<Band> getAllBands(){
    return bandDAO.getAllBands();
}

    @GetMapping ("bands/{bandName}")
    public List<Band> getBandsByName(@PathVariable String bandName) {
    return bandDAO.getBandsByName(bandName);
}

    @GetMapping ("bands/{genreName}")
    public List<Band> getBandsByGenre(@PathVariable String genreName) {
    return bandDAO.getBandsByName(genreName);
    }

    @GetMapping ("bands/{showId}")
    public List<Band> getBandsByShow(@PathVariable int showId) {
    return bandDAO.getBandsByShow(showId);
    }

    @GetMapping ("bands/{bandName}+{genreName}")
    public List<Band> getBandsByNameAndGenre(@PathVariable String bandName, @PathVariable String genreName) {
    return bandDAO.getBandsByNameAndGenre(bandName, genreName);
    }

    @PostMapping ("/bands")
    Band createBand(@Valid @RequestBody Band newBand){
    return bandDAO.createBand(newBand);
    }

    @DeleteMapping ("bands/{bandId}")
    public boolean deleteBand(@PathVariable int bandId) {
    return bandDAO.deleteBand(bandId);
    }

    @PutMapping ("/bands/{bandId}")  // takes in a bandID but provides a mgrId???
    public boolean updateBand(@Valid @RequestBody Band updatedBand, @PathVariable int mgrId){
    if (mgrId == updatedBand.getMgrId()) {
    return bandDAO.updateBand(updatedBand, mgrId);}
    else return false;
    }


}
