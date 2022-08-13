package com.techelevator.dao;

import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> getGenresByBand(int bandId);

    public boolean addGenreToBand(int bandId, int genreId);




}
