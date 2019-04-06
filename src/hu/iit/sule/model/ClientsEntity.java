package hu.iit.sule.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "infsysbuild")
public class ClientsEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "Nev")
    private String nev;
    @Basic
    @Column(name = "Telefon")
    private String telefon;
    @Basic
    @Column(name = "Szig_szam")
    private String szigSzam;
    @Basic
    @Column(name = "Lakcim")
    private String lakcim;
    @Basic
    @Column(name = "Aktiv")
    private boolean aktiv = true;

    public ClientsEntity() {
    }

    public ClientsEntity(String nev, String telefon, String szigSzam, String lakcim) {
        this.nev = nev;
        this.telefon = telefon;
        this.szigSzam = szigSzam;
        this.lakcim = lakcim;
    }


    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }


    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    public String getSzigSzam() {
        return szigSzam;
    }

    public void setSzigSzam(String szigSzam) {
        this.szigSzam = szigSzam;
    }


    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsEntity that = (ClientsEntity) o;
        return id == that.id &&
                aktiv == that.aktiv &&
                Objects.equals(nev, that.nev) &&
                Objects.equals(telefon, that.telefon) &&
                Objects.equals(szigSzam, that.szigSzam) &&
                Objects.equals(lakcim, that.lakcim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, telefon, szigSzam, lakcim, id, aktiv);
    }

    @Override
    public String toString() {
        return "ClientsEntity{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", telefon='" + telefon + '\'' +
                ", szigSzam='" + szigSzam + '\'' +
                ", lakcim='" + lakcim + '\'' +
                ", aktiv=" + aktiv +
                '}';
    }
}
