package com.techelevator.dao;

import com.techelevator.model.Band;

import java.util.List;

public interface BandDao {

    // List<User> getBandFollowers(int bandId); // probably needs moved to User DAO

    List<Band> getAllBands();

    Band getBandById(int bandId);

    List<Band> getBandsByName(String bandName);

    List<Band> getBandsByGenre(String genreName);

    List<Band> getBandsByShow(String showTitle);

    List<Band> getBandsByIdAndGenre(int bandId, int genreId);

    Band createBand(Band newBand);

    boolean updateBand(Band bandToUpdate, int bandId);

    boolean deleteBand(Band bandToDelete, int bandId);

    int findIdByBandName (String bandName);

}
