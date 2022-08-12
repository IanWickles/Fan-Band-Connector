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

        public List<Band> getBandsByGenre(int genreId){
            List<Band>  bands = new ArrayList<>();
            String sql = "SELECT * FROM band JOIN band_genre USING (band_id) JOIN genre USING (genre_id) WHERE genre_id = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }

            return bands;
        }

        public Band getBandById(int bandId) {
            String sql = "SELECT * FROM band WHERE band_id = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bandId);
            if(!results.next())
            {
                // throw?
                return null;
            }
            Band band = mapRowToBand(results);
            return band;
        }

        public List<Band> getBandsByShow(int showId) {
            List<Band> bands = new ArrayList<>();
            String sql = "SELECT * FROM band JOIN show_band USING (band_id) WHERE show_id = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, showId);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }
            return bands;
        }

        public List<Band> getAllBands() {
            List<Band> bands = new ArrayList<>();
            String sql = "SELECT * FROM band;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }
            return bands;
        }

        public List<Band> getBandsByIdAndGenre(int bandId, int genreId) {
            List<Band> bands = new ArrayList<>();
            String sql = "SELECT * FROM band JOIN band_genre USING (band_id) JOIN genre USING (genre_id) WHERE (genre_id = ?) AND (band_id = ?);";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }
            return bands;
        }

        public Band createBand(Band newBand, Integer MgrId) {  //not working, 500 internal server error
            String sql = "INSERT INTO band VALUES (band_name, band_description, band_member, manager_id) " + //removed band_id from SQL String
                        "VALUES (?, ?, ?, ?)";  //hm, how are we going to get the manager ID?

            //will need to be wrapped in Try/Catch

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newBand.getBandName(), newBand.getBandDesc(), newBand.getMembers(), MgrId);
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

            //needs exception handling...

        String sql = "DELETE FROM user_messages WHERE message_id = ANY(SELECT message_id FROM messages WHERE band_id = "+bandId+");"+
                     "DELETE FROM messages WHERE band_id = "+bandId+"; "+
                     "DELETE FROM band_genre WHERE band_id = "+bandId+"; "+
                     "DELETE FROM show_band WHERE band_id = "+bandId+"; "+
                     "DELETE FROM user_band WHERE band_id = "+bandId+"; "+
                     "DELETE FROM band WHERE band_id = "+bandId+";";
         return jdbcTemplate.update(sql) == 1; //if only 1 band deleted, it should return 1 row affected, 1 == 1;
    }




    private Band mapRowToBand (SqlRowSet rs) {
            Band band = new Band();

            band.setBandId(rs.getInt("band_id"));
            band.setBandName(rs.getString("band_name"));
            band.setBandDesc(rs.getString("band_description"));
            band.setMembers(rs.getString("band_member"));
            band.setMgrId(rs.getInt("manager_id"));

            return band;
         }

    }


