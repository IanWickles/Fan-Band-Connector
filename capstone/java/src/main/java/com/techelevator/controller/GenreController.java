package com.techelevator.controller;


import com.techelevator.dao.GenreDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Genre;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class GenreController {

    GenreDao genreDao;
    UserDao userDao;

    public GenreController (GenreDao genreDao, UserDao userDao) {
        this.genreDao = genreDao;
        this.userDao = userDao;
    }

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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/genres/newGenre") //WORKING: Postman confirmed
    Genre createGenre(@RequestBody Genre newGenre, @Valid Principal user) {
            return genreDao.createGenre(newGenre);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/genres/{genreId}") //WORKING: Postman confirmed
    public boolean deleteGenre (Genre genreToDelete, @PathVariable int genreId) {
            return genreDao.deleteGenre(genreToDelete, genreId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/genres/bands/{bandId}")
    public void addGenreToBand (@PathVariable int bandId, @RequestBody int genreId) {
            genreDao.addGenreToBand(bandId, genreId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/genres/bands/{bandId}")
    public void removeGenreFromBand(@PathVariable int bandId, @RequestBody int genreId) {
        genreDao.removeGenreFromBand(bandId, genreId);
    }
}
