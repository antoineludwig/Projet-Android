package com.projet.esgi.meteoesgial1.modele;

import java.util.Date;

public class MeteoData {
    private Date date;
    private double temp;
    private double humidity;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double windSpeed;
    private double windDirection;

    public MeteoData(){

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
}
