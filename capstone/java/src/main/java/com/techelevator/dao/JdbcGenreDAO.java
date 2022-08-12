package com.techelevator.dao;

import com.techelevator.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGenreDao implements GenreDao{

    JdbcTemplate jdbcTemplate;

    public  JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Genre> getGenresByBand(int bandId) {

        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genre JOIN band_genre USING (genre_id) JOIN band USING (band_id) WHERE band_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bandId);
        while (results.next()){
        Genre genre = mapRowToGenre(results);
        genres.add(genre);
        }
        return genres;
    }

    @Override
    public boolean addGenreToBand(int bandId, int genreId) {
        String sql = "INSERT INTO band_genre (band_id, genre_id) VALUES (?, ?)";
        try{
            jdbcTemplate.queryForRowSet(sql, bandId, genreId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private Genre mapRowToGenre(SqlRowSet rs) {
        Genre genre = new Genre();

        genre.setGenreId(rs.getInt("genre_id"));
        genre.setGenreName(rs.getString("genre_name"));

        return genre;
    }
}
