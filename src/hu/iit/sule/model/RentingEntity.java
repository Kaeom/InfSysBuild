package hu.iit.sule.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "renting", schema = "infsysbuild", catalog = "")
public class RentingEntity {
    private int id;
    private Date kezdes;
    private Date lejarat;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Kezdes")
    public Date getKezdes() {
        return kezdes;
    }

    public void setKezdes(Date kezdes) {
        this.kezdes = kezdes;
    }

    @Basic
    @Column(name = "Lejarat")
    public Date getLejarat() {
        return lejarat;
    }

    public void setLejarat(Date lejarat) {
        this.lejarat = lejarat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentingEntity that = (RentingEntity) o;
        return id == that.id &&
                Objects.equals(kezdes, that.kezdes) &&
                Objects.equals(lejarat, that.lejarat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kezdes, lejarat);
    }
}
