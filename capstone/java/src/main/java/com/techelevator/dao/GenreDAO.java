package com.techelevator.dao;

import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getAllGenres();

    Genre getGenreByID (int genreId);

    List<Genre> getGenresByBand(String bandName);

    Genre createGenre(Genre newGenre);

    boolean deleteGenre(Genre genreToDelete, int genreID);

    public void addGenreToBand(int bandId, int genreId);

    public void removeGenreFromBand(int bandId, int genreId);




}
