package hu.autoapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "auto")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 6, max = 10, message = "Az rendszám min. 6 max 10 karakter")
    @Column(unique = true)
    private String rendszam;

    @Size(min = 1, max = 100, message = "Az márka min 1 max 100 karakter")
    @Column(unique = true)
    private String marka;

    @Size(min = 1, max = 100, message = "Az model min 1 max 100 karakter")
    @Column(unique = true)
    private String model;

    @Size(min = 1, max = 100, message = "Az típusjel min 1 max 100 karakter")
    @Column(unique = true)
    private String tipusjel;

    @Min(value = 1900, message = "Az érték 1900-nál kisebb")
    @Max(value = 2024, message = "Az érték 2024-nél nagyobb")
    private int evjarat;

    @Size(min = 3, max = 50, message = "Az üzemanyag elnevezése min 3 max 50 karakter")
    @Column(unique = true)
    private String uzemanyag;

    @Min(value = 500, message = "Érték 500-nál kisebb")
    @Max(value = 20000, message = "Érték 20000-nél nagyobb")
    private int hengerurtartalom;

    @Min(value = 10, message = "Érték 10 nél kisebb")
    @Max(value = 1000, message = "Érték 1000 nál nagyobb")
    private int teljesitmeny;

    public Cars(int id, String rendszam, String marka, String model, String tipusjel,
                int evjarat, String uzemanyag, int hengerurtartalom, int teljesitmeny) {
        this.id = id;
        this.rendszam = rendszam;
        this.marka = marka;
        this.model = model;
        this.tipusjel = tipusjel;
        this.evjarat = evjarat;
        this.uzemanyag = uzemanyag;
        this.hengerurtartalom = hengerurtartalom;
        this.teljesitmeny = teljesitmeny;
    }

    public Cars() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTipusjel() {
        return tipusjel;
    }

    public void setTipusjel(String tipusjel) {
        this.tipusjel = tipusjel;
    }

    public int getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(int evjarat) {
        this.evjarat = evjarat;
    }

    public String getUzemanyag() {
        return uzemanyag;
    }

    public void setUzemanyag(String uzemanyag) {
        this.uzemanyag = uzemanyag;
    }

    public int getHengerurtartalom() {
        return hengerurtartalom;
    }

    public void setHengerurtartalom(int hengerurtartalom) {
        this.hengerurtartalom = hengerurtartalom;
    }

    public int getTeljesitmeny() {
        return teljesitmeny;
    }

    public void setTeljesitmeny(int teljesitmeny) {
        this.teljesitmeny = teljesitmeny;
    }
}
