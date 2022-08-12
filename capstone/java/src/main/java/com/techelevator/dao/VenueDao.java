package com.techelevator.dao;

import com.techelevator.model.Venue;
import java.util.List;

public interface VenueDao {

    List<Venue> getAllVenues();

    List<Venue> getVenueById(int venueId);

}
