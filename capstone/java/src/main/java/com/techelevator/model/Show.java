package com.techelevator.model;

import java.util.Date;

public class Show {


    private int showId;
    private Date showTime;
    private String showTitle;
    private String showDesc;
    private int venueId;

    public Show(int showId, Date showTime, String showTitle, String showDesc, int venueId) {
        this.showId = showId;
        this.showTime = showTime;
        this.showTitle = showTitle;
        this.showDesc = showDesc;
        this.venueId = venueId;
    }

    public Show() {

    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }
}
