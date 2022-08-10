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

    List<Band> getBandsByShow(int showId);

    List<Band> getBandsByNameAndGenre(String bandName, String genreName);



    Band createBand(Band newBand);

    boolean deleteBand(int bandId);

    boolean updateBand(Band updatedBand, int mgrId);





}
