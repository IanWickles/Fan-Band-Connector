package com.techelevator.dao;

import com.techelevator.model.Band;
import com.techelevator.model.Genre;
import com.techelevator.model.Show;
import com.techelevator.model.User;

import java.util.List;

public interface BandDAO {

    // List<User> getBandFollowers(int bandId); // probably needs moved to User DAO

    List<Band> getAllBands();

    List<Band>  getBandsById(int bandId);

    List<Band> getBandsByGenre(int genreId);

    List<Band> getBandsByShow(int showId);

    List<Band> getBandsByIdAndGenre(int bandId, int genreId);



    Band createBand(Band newBand, Integer MgrId);

    boolean deleteBand(Integer bandId);

    boolean updateBand(Band updatedBand, int mgrId);





}
