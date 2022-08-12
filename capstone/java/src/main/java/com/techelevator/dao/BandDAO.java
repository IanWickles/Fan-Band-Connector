package com.techelevator.dao;

import com.techelevator.model.Band;

import java.util.List;

public interface BandDao {

    // List<User> getBandFollowers(int bandId); // probably needs moved to User DAO

    List<Band> getAllBands();

    Band getBandById(int bandId);

    List<Band> getBandsByGenre(int genreId);

    List<Band> getBandsByShow(int showId);

    List<Band> getBandsByIdAndGenre(int bandId, int genreId);

    Band createBand(Band newBand);

    boolean updateBand(Band bandToUpdate, int bandId);

    boolean deleteBand(Band bandToDelete, int bandId);

    int findIdByBandName (String bandName);

}













