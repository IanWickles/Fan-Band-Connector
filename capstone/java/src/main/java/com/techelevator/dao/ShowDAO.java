package com.techelevator.dao;

import com.techelevator.model.Show;
import java.util.List;

public interface ShowDAO {

    List<Show> getShowsByVenue(String venueName);

    List<Show> getShowsByBand(String bandName);

    //OPTIONAL - getShowsByDate();

    Show addShow();
    Show updateShow (int showId);
    void deleteShow (int showId);

}
