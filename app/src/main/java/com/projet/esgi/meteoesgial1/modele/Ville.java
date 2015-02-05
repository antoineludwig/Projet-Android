package com.projet.esgi.meteoesgial1.modele;

public class Ville {
    private String nom;
    private double longitude;
    private double latitude;

    private MeteoData meteoData;

    public Ville(){

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public MeteoData getMeteoData() {
        return meteoData;
    }

    public void setMeteoData(MeteoData meteoData) {
        this.meteoData = meteoData;
    }
}
