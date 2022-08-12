package com.techelevator.dao;

import com.techelevator.model.Show;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class JdbcShowDao implements ShowDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcShowDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Show> getShowsByVenue(int venueId) {
        List<Show> shows = new LinkedList<>();
        String sql = "SELECT * FROM show JOIN venue USING (venue_id) WHERE venue_id = ?;";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql, venueId);

        while (results.next()) {
            Show show = mapShowToRowSet(results);
            shows.add(show);
        }
        return shows;
    }

    public List<Show> getShowsByBand(int bandId){
        List<Show> shows = new LinkedList<>();
        String sql = "SELECT * FROM show JOIN show_band USING (show_id) JOIN band USING (band_id) WHERE band_id = ?;";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql, bandId);

        while (results.next()) {
            Show show = mapShowToRowSet(results);
            shows.add(show);
        }

        return shows;
    }

    //OPTIONAL - getShowsByDate();

    public Show addShow(){
        return null;
    }
    public Show updateShow (int showId){
        return null;
    }
    public void deleteShow (int showId){

    }

    private Show mapShowToRowSet (SqlRowSet rs) {
        Show show = new Show();


        show.setShowId(rs.getInt("show_id"));
        show.setShowTime(rs.getDate("show_time"));
        show.setShowTitle(rs.getString("show_title"));
        show.setShowDesc(rs.getString("show_description"));
        show.setVenueId(rs.getInt("venue_id"));


        return show;
    }

}
