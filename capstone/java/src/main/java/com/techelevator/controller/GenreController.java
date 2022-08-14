package com.techelevator.controller;


import com.techelevator.dao.GenreDao;
import com.techelevator.model.Genre;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class GenreController {

    GenreDao genreDao;

    public GenreController (GenreDao genreDao) {this.genreDao = genreDao;}

    @GetMapping("/genres") //WORKING: Postman confirmed
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }

    @GetMapping("/genres/{genreId}") //WORKING: Postman confirmed
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

    @PostMapping("/genres/bands/{bandId}")
    public void addGenreToBand (@PathVariable int bandId, @RequestBody int genreId) {
        genreDao.addGenreToBand(bandId, genreId);
    }

    @DeleteMapping("/genres/bands/{bandId}")
    public void removeGenreFromBand(@PathVariable int bandId, @RequestBody int genreId) {genreDao.removeGenreFromBand(bandId, genreId);}


}
