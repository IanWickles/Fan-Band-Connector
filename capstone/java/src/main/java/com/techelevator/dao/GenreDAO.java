package com.techelevator.dao;

import com.techelevator.model.Band;
import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDAO {

    List<Genre> getGenresByBand(int bandId);




}
