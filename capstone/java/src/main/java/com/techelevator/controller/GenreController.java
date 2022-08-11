package com.techelevator.controller;

import com.techelevator.dao.GenreDAO;
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

    GenreDAO genreDAO;

    private GenreController (GenreDAO genreDAO) {this.genreDAO = genreDAO;}

    @GetMapping ("/genre/bands/{bandId}")
    List<Genre> getGenresByBand(@PathVariable String bandId) {
        return genreDAO.getGenresByBand(bandId);
    }


}
