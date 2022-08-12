package com.techelevator.controller;


import com.techelevator.dao.GenreDao;
import com.techelevator.model.Genre;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class GenreController {

    GenreDao genreDao;

    private GenreController (GenreDao genreDAO) {this.genreDao = genreDao;}

    //Not working suddenly...
    @GetMapping ("/genre/bands/{bandId}")
    List<Genre> getGenresByBand(@PathVariable int bandId) {
        return genreDao.getGenresByBand(bandId);
    }


}
