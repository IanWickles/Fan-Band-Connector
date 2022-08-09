package com.techelevator.dao;

import com.techelevator.model.Band;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBandDao implements BandDAO {

        JdbcTemplate jdbcTemplate;

        public JdbcBandDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public List<Band> getBandsByGenre(String genreName){
            List<Band>  bands = new ArrayList<>();
            String sql = "SELECT band_name FROM band JOIN band-genre USING (band_id) JOIN genre USING (genre_id) WHERE genre_name = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreName);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }

            return bands;
        }

        public List<Band>  getBandsByName(String bandName) {
            List<Band> bands = new ArrayList<>();
            String sql = "SELECT band_name FROM band WHERE band_name = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bandName);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }

            return bands;
        }

        public List<Band> getBandsByShow(String showTitle) {

            List<Band> bands = new ArrayList<>();
            String sql = "SELECT band_name FROM band JOIN band_show USING (band_id) WHERE show_id = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, showTitle);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }

            return bands;
        }

        public List<Band> getAllBands() {

            List<Band> bands = new ArrayList<>();
            String sql = "SELECT band_name FROM band;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }

            return bands;
        }

        public List<Band> getBandsByNameAndGenre(String bandName, String genreName) {

        return null;
        }


    public Band createBand() {
        return null;
    }


    public Band updateBand(int bandId) {
            return null;
    }


    public void deleteBand(int bandId) {

    }

    private Band mapRowToBand (SqlRowSet rs) {
            Band band = new Band();

            band.setBandId(rs.getInt("band_id"));
            band.setBandName(rs.getString("band_name"));
            band.setBandDesc(rs.getString("band_description"));
            band.setMembers(rs.getString("members"));
            band.setMgrId(rs.getInt("manager_id"));

            return band;
        }

    }


