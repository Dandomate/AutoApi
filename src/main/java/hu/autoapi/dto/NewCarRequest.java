package hu.autoapi.dto;

import hu.autoapi.domain.Car;

public class NewCarRequest {
    private String rendszam;

    private String marka;

    private String model;

    private String tipusjel;

    private int evjarat;

    private String uzemanyag;

    private int hengerurtartalom;

    private int teljesitmeny;

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

    public Car toCar() {
        Car cars = new Car();
        cars.setRendszam(this.rendszam);
        cars.setMarka(this.marka);
        cars.setModel(this.model);
        cars.setTipusjel(this.tipusjel);
        cars.setEvjarat(this.evjarat);
        cars.setUzemanyag(this.uzemanyag);
        cars.setHengerurtartalom(this.hengerurtartalom);
        cars.setTeljesitmeny(this.teljesitmeny);
        return cars;
    }


    @Override
    public String toString() {
        return "NewClassRoomRequest{" +
                "Rendszám='" + rendszam + '\'' +
                "Márka='" + marka + '\'' +
                "Model='" + model + '\'' +
                "Típusjel='" + tipusjel + '\'' +
                "Évjárat='" + evjarat + '\'' +
                "Üzemanyag='" + uzemanyag + '\'' +
                "Hengerűrtartalom='" + hengerurtartalom + '\'' +
                ", Teljesítmény=" + teljesitmeny +
                '}';
    }
}
