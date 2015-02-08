package com.projet.esgi.meteoesgial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.projet.esgi.meteoesgial1.modele.Ville;


public class VilleActivity extends Activity {

    private Button boutonRetour;
    private CheckBox checkFavoris;
    private Ville laVille = new Ville();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ville);
        TextView nomDeLaVille = (TextView)findViewById(R.id.nomVille);

        initElements();

        Intent i = getIntent();
        laVille = (Ville)i.getSerializableExtra("ville");
        nomDeLaVille.setText(laVille.getNom());
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

    private void initElements(){
        boutonRetour = (Button) findViewById(R.id.retour);
        checkFavoris = (CheckBox) findViewById(R.id.favoris);
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

                laVille.setFavoris(true);

            }
        });
    }
}
