package hu.iit.sule.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "renting", schema = "infsysbuild")
public class RentingEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name ="ClientId")
    private int clientId;
    @Basic
    @Column(name ="MoviesId")
    private int movieID;
    @Basic
    @Column(name = "Kezdes")
    private Date kezdes;
    @Basic
    @Column(name = "Lejarat")
    private Date lejarat;

    public RentingEntity() {
    }

    public RentingEntity(int clientId, int movieID, Date kezdes, Date lejarat) {
        this.clientId = clientId;
        this.movieID = movieID;
        this.kezdes = kezdes;
        this.lejarat = lejarat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Date getKezdes() {
        return kezdes;
    }

    public void setKezdes(Date kezdes) {
        this.kezdes = kezdes;
    }


    public Date getLejarat() {
        return lejarat;
    }

    public void setLejarat(Date lejarat) {
        this.lejarat = lejarat;
    }

    @Override
    public String toString() {
        return "RentingEntity{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", movieID=" + movieID +
                ", kezdes=" + kezdes +
                ", lejarat=" + lejarat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentingEntity that = (RentingEntity) o;
        return id == that.id &&
                Objects.equals(kezdes, that.kezdes) &&
                Objects.equals(lejarat, that.lejarat) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(movieID, that.movieID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,clientId, movieID, kezdes, lejarat);
    }
}
