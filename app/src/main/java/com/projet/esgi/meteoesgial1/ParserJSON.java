package com.projet.esgi.meteoesgial1;

import com.projet.esgi.meteoesgial1.modele.MeteoData;
import com.projet.esgi.meteoesgial1.modele.Ville;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParserJSON {
    private String json;

    public Ville parseCurrentWeatherData() throws JSONException {
        if (json != null) {
            Ville ville = new Ville();

            JSONObject jsonObject = new JSONObject(json);
            ville.setNom(jsonObject.getString("name"));
            ville.setLatitude(jsonObject.getDouble("lat"));
            ville.setLongitude(jsonObject.getDouble("long"));

            JSONObject jsonMain = jsonObject.getJSONObject("main");
            MeteoData meteoData = new MeteoData();
            meteoData.setDate(jsonMain.getLong("dt"));
            meteoData.setTemp(jsonMain.getDouble("temp"));
            meteoData.setHumidity(jsonMain.getDouble("humidity"));
            meteoData.setTemp_min(jsonMain.getDouble("temp_min"));
            meteoData.setTemp_max(jsonMain.getDouble("temp_max"));
            meteoData.setPressure(jsonMain.getDouble("pressure"));

            JSONObject jsonWind = jsonObject.getJSONObject("wind");
            meteoData.setWindSpeed(jsonWind.getDouble("speed"));
            meteoData.setWindDirection(jsonWind.getDouble("deg"));

            ville.setMeteoData(meteoData);

            return ville;
        }else{
            return null;
        }
    }

}
