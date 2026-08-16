package models;

import java.util.*;

public class Theatre {
    private String pvrName;
    private String city;
    private int capacity;
    private List<Show> shows;

    public Theatre(String pvrName, String city, int capacity) {
        this.pvrName = pvrName;
        this.city = city;
        this.capacity = capacity;
    }

    public Theatre(String pvrName, String city, List<Show> shows,  int capacity) {
        this.pvrName = pvrName;
        this.city = city;
        this.shows = shows;
        this.capacity = capacity;
    }

    public String getPvrName() {
        return pvrName;
    }

    public void setPvrName(String pvrName) {
        this.pvrName = pvrName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
