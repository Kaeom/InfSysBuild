package hu.iit.sule.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "infsysbuild")
public class ClientsEntity {
    private int id;
    private String nev;
    private String telefon;
    private String szigSzam;
    private String lakcim;
    private boolean aktiv = true;

    public ClientsEntity() {
    }

    public ClientsEntity(String nev, String telefon, String szigSzam, String lakcim) {
        this.nev = nev;
        this.telefon = telefon;
        this.szigSzam = szigSzam;
        this.lakcim = lakcim;
    }

    @Basic
    @Column(name = "Nev")
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    @Basic
    @Column(name = "Telefon")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Basic
    @Column(name = "Szig_szam")
    public String getSzigSzam() {
        return szigSzam;
    }

    public void setSzigSzam(String szigSzam) {
        this.szigSzam = szigSzam;
    }

    @Basic
    @Column(name = "Lakcim")
    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Aktiv")
    public boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
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
