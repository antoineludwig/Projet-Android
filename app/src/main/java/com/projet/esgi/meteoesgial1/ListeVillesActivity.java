package com.projet.esgi.meteoesgial1;

<<<<<<< HEAD:app/src/main/java/com/projet/esgi/meteoesgial1/ListeVilles.java
import android.app.Activity;
import android.content.Intent;
=======
import android.support.v7.app.ActionBarActivity;
>>>>>>> 3a3773acacad9a404d2957cb65cb0394e7d39740:app/src/main/java/com/projet/esgi/meteoesgial1/ListeVillesActivity.java
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ListeVillesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_villes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste_villes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

<<<<<<< HEAD:app/src/main/java/com/projet/esgi/meteoesgial1/ListeVilles.java
        //récupère la liste de ville
        ListView li = (ListView) findViewById(R.id.listeVille);
        li.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                startActivity(intent);
                //TO DO ouvre l'autre activity
            }
        });

=======
>>>>>>> 3a3773acacad9a404d2957cb65cb0394e7d39740:app/src/main/java/com/projet/esgi/meteoesgial1/ListeVillesActivity.java
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
