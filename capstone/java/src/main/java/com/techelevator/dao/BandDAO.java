package com.techelevator.dao;

import com.techelevator.model.Band;
import com.techelevator.model.Genre;
import com.techelevator.model.Show;
import com.techelevator.model.User;

import java.util.List;

public interface BandDAO {

    // List<User> getBandFollowers(int bandId); // probably needs moved to User DAO

    List<Band> getAllBands();

    List<Band>  getBandsByName(String bandName);

    List<Band> getBandsByGenre(String genreName);

    List<Band> getBandsByShow(String showTitle);

    List<Band> getBandsByNameAndGenre(String bandName, String genreName);



    Band createBand();

    boolean deleteBand(int bandId);

    Band updateBand(Band updatedBand, int bandId);





}