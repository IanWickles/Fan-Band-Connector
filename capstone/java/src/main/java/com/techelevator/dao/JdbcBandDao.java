package com.techelevator.dao;

import com.techelevator.model.Band;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBandDao implements BandDao {

    JdbcTemplate jdbcTemplate;

    public JdbcBandDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Band> getAllBands() {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * FROM band;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Band band = mapRowToBand(results);
            bands.add(band);
        }
        return bands;
    }

    public Band getBandById(int bandId) {
        Band band = new Band();
        String sql = "SELECT * FROM band WHERE band_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bandId);
        if (!results.next()) {
            band = mapRowToBand(results);
        }
        return band;
    }

    public List<Band> getBandsByGenre(int genreId) {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * FROM band JOIN band_genre USING (band_id) JOIN genre USING (genre_id) WHERE genre_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
        while (results.next()) {
            Band band = mapRowToBand(results);
            bands.add(band);
        }

        return bands;
    }

    public List<Band> getBandsByShow(int showId) {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * FROM band JOIN show_band USING (band_id) WHERE show_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, showId);
        while (results.next()) {
            Band band = mapRowToBand(results);
            bands.add(band);
        }
        return bands;
    }

    public List<Band> getBandsByIdAndGenre(int bandId, int genreId) {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * FROM band JOIN band_genre USING (band_id) JOIN genre USING (genre_id) WHERE (genre_id = ?) AND (band_id = ?);";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Band band = mapRowToBand(results);
            bands.add(band);
        }
        return bands;
    }

    public boolean createBand(Band newBand, int managerId) {
        String sql = "INSERT INTO band VALUES (band_name, band_description, band_member, manager_id) " +
                "VALUES (?, ?, ?, ?);";
        try {
            jdbcTemplate.queryForRowSet(sql, newBand.getBandName(), newBand.getBandDesc(), newBand.getMembers(), managerId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateBand(Band bandToUpdate, int bandId) {
        String sql = "UPDATE band SET band_name = ?, band_description = ?, band_member = ?, manager_id = ? WHERE band_id = ?;";
        try {
            jdbcTemplate.update(sql, bandToUpdate.getBandName(), bandToUpdate.getBandDesc(), bandToUpdate.getMembers(), bandToUpdate.getMgrId(), bandId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteBand(Band bandToDelete, int bandId) {
        String sql = "DELETE FROM user_messages WHERE message_id = ANY(SELECT message_id FROM messages WHERE band_id = " + bandId + ");" +
                "DELETE FROM messages WHERE band_id = " + bandId + "; " +
                "DELETE FROM band_genre WHERE band_id = " + bandId + "; " +
                "DELETE FROM show_band WHERE band_id = " + bandId + "; " +
                "DELETE FROM user_band WHERE band_id = " + bandId + "; " +
                "DELETE FROM band WHERE band_id = " + bandId + ";";
        try {
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private Band mapRowToBand(SqlRowSet rs) {
        Band band = new Band();

        band.setBandId(rs.getInt("band_id"));
        band.setBandName(rs.getString("band_name"));
        band.setBandDesc(rs.getString("band_description"));
        band.setMembers(rs.getString("band_member"));
        band.setMgrId(rs.getInt("manager_id"));

        return band;
    }

}


