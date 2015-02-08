package com.projet.esgi.meteoesgial1;

import android.os.AsyncTask;
import android.util.Log;

import com.projet.esgi.meteoesgial1.modele.MeteoData;


public class CurrentWeatherTask extends AsyncTask<String, Void, MeteoData> {


    @Override
    protected MeteoData doInBackground(String... params) {
        MeteoData meteoData = null;
        String rsltRequete = "";
        try {
            RequeteurAPI requeteurAPI = new RequeteurAPI();
            rsltRequete = requeteurAPI.queryCurrentWeather(params[0], params[1]);

            meteoData = ParserJSON.parseCurrentWeatherData(rsltRequete);
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("Erreur", rsltRequete);
        }
        return meteoData;
    }
}
