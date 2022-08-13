package com.techelevator.dao;

import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getAllGenres();

    Genre getGenreByID (int genreId);

    List<Genre> getGenresByBand(String bandName);

    Genre createGenre(Genre newGenre);

    boolean deleteGenre(Genre genreToDelete, int genreID);

    public void addGenreToBand(int genreId, int bandId);

    public void removeGenreFromBand(int genreId, int bandId);




}
