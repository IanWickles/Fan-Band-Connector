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
            String sql = "SELECT band_name FROM band JOIN band_genre USING (band_id) JOIN genre USING (genre_id) WHERE genre_name = ?;";

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

        public List<Band> getBandsByShow(int showId) {
            List<Band> bands = new ArrayList<>();
            String sql = "SELECT band_name FROM band JOIN show_band USING (band_id) WHERE show_id = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, showId);
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
            List<Band> bands = new ArrayList<>();
            String sql = "SELECT band_name FROM band JOIN band_genre USING (band_id) JOIN genre USING (genre_id) WHERE (genre_name = ?) AND (band_name = ?);";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }
            return bands;
        }

        public Band createBand(Band newBand) {     //maybe also take in a userId??
            String sql = "INSERT INTO band VALUES (band_id, band_name, band_description, band_member, manager_id) " +
                        "(default, ?, ?, ?, ?)"; //does manager ID need to be a subquery??

            //will need to be wrapped in Try/Catch

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newBand.getBandName(), newBand.getBandDesc(), newBand.getMembers(), newBand.getMgrId()); //should this take in a userId or getMgrId??
            if (results.next()) {
                int id = newBand.getBandId();
                newBand.setBandId(id);
                return newBand;
            }

            return null;
        }

        public boolean updateBand(Band updatedBand, int mgrId) {
            String sql = "UPDATE band SET band_name = ?, band_description = ?, band_member = ?, manager_id = ? WHERE manager_id = ?; ";
            return jdbcTemplate.update(sql, updatedBand.getBandName(), updatedBand.getBandDesc(), updatedBand.getMembers(), updatedBand.getMgrId(), mgrId) == 1;

            // add exception handling for changing managerId to a band that already has ownership
        }

        public boolean deleteBand(int bandId) {
            String sql = "DELETE FROM band WHERE band_id = ?";
            return jdbcTemplate.update(sql, bandId) == 1;
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


