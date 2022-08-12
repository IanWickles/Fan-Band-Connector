package com.techelevator.dao;

import com.techelevator.model.Show;
import java.util.List;

public interface ShowDao {

    List<Show> getShowsByVenue(int venueId);

    List<Show> getShowsByBand(int bandId);

    //OPTIONAL - getShowsByDate();

    Show addShow();
    Show updateShow (int showId);
    void deleteShow (int showId);

}
