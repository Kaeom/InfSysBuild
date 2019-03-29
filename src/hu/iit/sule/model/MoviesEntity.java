package hu.iit.sule.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "infsysbuild")
public class MoviesEntity {
    private int id;
    private String cim;
    private Date datum;
    private String sorszam;
    private String status;
    private String tipus;

    public MoviesEntity() {
    }

    public MoviesEntity(String cim, Date datum, String sorszam, String status, String tipus) {
        this.cim = cim;
        this.datum = datum;
        this.sorszam = sorszam;
        this.status = status;
        this.tipus = tipus;
    }

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Cim")
    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    @Basic
    @Column(name = "Datum")
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "Sorszam")
    public String getSorszam() {
        return sorszam;
    }

    public void setSorszam(String sorszam) {
        this.sorszam = sorszam;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Tipus")
    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(cim, that.cim) &&
                Objects.equals(datum, that.datum) &&
                Objects.equals(sorszam, that.sorszam) &&
                Objects.equals(tipus, that.tipus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cim, datum, sorszam, status, tipus);
    }

    @Override
    public String toString() {
        return "MoviesEntity{" +
                "id=" + id +
                ", cim='" + cim + '\'' +
                ", datum=" + datum +
                ", sorszam='" + sorszam + '\'' +
                ", status='" + status + '\'' +
                ", tipus='" + tipus + '\'' +
                '}';
    }
}
