package com.projet.esgi.meteoesgial1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.projet.esgi.meteoesgial1.MeteoAPI.CurrentWeatherTask;
import com.projet.esgi.meteoesgial1.MeteoApplication;
import com.projet.esgi.meteoesgial1.R;
import com.projet.esgi.meteoesgial1.modele.MeteoData;
import com.projet.esgi.meteoesgial1.modele.Ville;


public class VilleActivity extends Activity {

    private Button boutonRetour;
    private CheckBox checkFavoris;
    private Ville laVille = new Ville();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ville);

        Intent i = getIntent();
        laVille = (Ville)i.getSerializableExtra("ville");

        initElements();
        launchSearchTask();
        initAffichageVille();
    }

    private void initElements(){
        boutonRetour = (Button) findViewById(R.id.retour);
        checkFavoris = (CheckBox) findViewById(R.id.favoris);
        checkFavoris.setChecked(laVille.isFavoris());
        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VilleActivity.this,ListeVillesActivity.class);
                startActivity(intent);
            }
        });
        checkFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkFavoris.isChecked()){
                    ((MeteoApplication)getApplication()).addFavoris(laVille);
                }else{
                    ((MeteoApplication)getApplication()).removeFavoris(laVille);
                }


            }
        });
    }

    private void initAffichageVille() {
        TextView nomDeLaVille = (TextView)findViewById(R.id.nomVille);
        nomDeLaVille.setText(laVille.getNom());

        MeteoData meteoData = laVille.getMeteoData();
        if(meteoData != null) {
            TextView temp = (TextView) findViewById(R.id.temperatureVille);
            temp.setText(meteoData.getTempCelcius());
            ImageView image = (ImageView) findViewById(R.id.logo);
            image.setImageResource(meteoData.getIdPicture());
        }
    }

    private void launchSearchTask() {
        CurrentWeatherTask searchTask = new CurrentWeatherTask();
        searchTask.execute(laVille.getNom(), getBaseContext().getString(R.string.langue_API));

        try{
            MeteoData meteoData = searchTask.get();
            laVille.setMeteoData(meteoData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ville, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
