package hu.iit.sule.model;

import java.util.Date;

public class RentingByClient {

    private int id;
    private int clientID;
    private int movieID;
    private String movieCim;
    private Date movieDatum;
    private String movieSorszam;
    private String movieStatus;
    private String movietipus;
    private Date rentingStart;
    private Date rentindEnd;

    public RentingByClient(int id, int clientID, int movieID, String movieCim, Date movieDatum, String movieSorszam, String movieStatus, String movietipus, Date rentingStart, Date rentindEnd) {
        this.id = id;
        this.clientID = clientID;
        this.movieID = movieID;
        this.movieCim = movieCim;
        this.movieDatum = movieDatum;
        this.movieSorszam = movieSorszam;
        this.movieStatus = movieStatus;
        this.movietipus = movietipus;
        this.rentingStart = rentingStart;
        this.rentindEnd = rentindEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieCim() {
        return movieCim;
    }

    public void setMovieCim(String movieCim) {
        this.movieCim = movieCim;
    }

    public Date getMovieDatum() {
        return movieDatum;
    }

    public void setMovieDatum(Date movieDatum) {
        this.movieDatum = movieDatum;
    }

    public String getMovieSorszam() {
        return movieSorszam;
    }

    public void setMovieSorszam(String movieSorszam) {
        this.movieSorszam = movieSorszam;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovietipus() {
        return movietipus;
    }

    public void setMovietipus(String movietipus) {
        this.movietipus = movietipus;
    }

    public Date getRentingStart() {
        return rentingStart;
    }

    public void setRentingStart(Date rentingStart) {
        this.rentingStart = rentingStart;
    }

    public Date getRentindEnd() {
        return rentindEnd;
    }

    public void setRentindEnd(Date rentindEnd) {
        this.rentindEnd = rentindEnd;
    }

    @Override
    public String toString() {
        return "RentingByClient{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", movieID=" + movieID +
                ", movieCim='" + movieCim + '\'' +
                ", movieDatum=" + movieDatum +
                ", movieSorszam='" + movieSorszam + '\'' +
                ", movieStatus='" + movieStatus + '\'' +
                ", movietipus='" + movietipus + '\'' +
                ", rentingStart=" + rentingStart +
                ", rentindEnd=" + rentindEnd +
                '}';
    }
}
