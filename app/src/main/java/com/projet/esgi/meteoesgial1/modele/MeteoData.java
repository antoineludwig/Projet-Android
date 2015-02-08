package com.projet.esgi.meteoesgial1.modele;

import java.util.Date;
import com.projet.esgi.meteoesgial1.R;

public class MeteoData {
    private Date date;
    private int id;
    private String description;
    private double temp;
    private double humidity;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double windSpeed;
    private double windDirection;


    //Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(long unixTime) {
        // Unix Time en secondes
        this.date = new Date(unixTime*1000);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }


    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }


    //Fonctions spécifiques
    public String getTempCelcius(){
        return String.format("%.1f °C", this.temp);
    }

    public int getIdPicture(){
        if(id >= 200 && id < 300){
            return R.drawable.thunderstorm;
        }else if(id >= 200 && id < 300){
            return R.drawable.drizzle;
        }else if(id >= 500 && id < 600){
            return R.drawable.rain;
        }else if(id >= 600 && id < 700){
            return R.drawable.snow;
        }else if(id >= 700 && id < 800){
            return R.drawable.mist;
        }else if(id == 800){
            return R.drawable.clear;
        }else if(id == 801){
            return R.drawable.few_clouds;
        }else if(id >= 802 && id < 900){
            return R.drawable.cloudy;
        }

        return R.drawable.special;
    }
}
