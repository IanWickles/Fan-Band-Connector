package com.techelevator.controller;


import com.techelevator.dao.GenreDao;
import com.techelevator.model.Band;
import com.techelevator.model.Genre;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
// @PreAuthorize("isAuthenticated()")
public class GenreController {

    GenreDao genreDao;

    private GenreController (GenreDao genreDao) {this.genreDao = genreDao;}

    @GetMapping("/genres") //WORKING: Postman confirmed
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }

    @GetMapping("/genres/details/{genreId}") //WORKING: Postman confirmed
    public Genre getGenreById(@PathVariable int genreId) {
        return genreDao.getGenreByID(genreId);
    }

    @GetMapping ("/genre/bands/{bandName}") //WORKING: Postman confirmed
    List<Genre> getGenresByBand(@PathVariable String bandName) {
        return genreDao.getGenresByBand(bandName);
    }

    @PostMapping("/genres/newgenre") //WORKING: Postman confirmed
    Genre createGenre(@RequestBody Genre newGenre) {
        return genreDao.createGenre(newGenre);
    }

    @DeleteMapping("/genres/{genreId}") //WORKING: Postman confirmed
    public boolean deleteGenre (Genre genreToDelete, @PathVariable int genreId) {
        return genreDao.deleteGenre(genreToDelete, genreId);
    }


}
