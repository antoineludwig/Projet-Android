package com.projet.esgi.meteoesgial1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Switch;


public class ListeVillesActivity extends Activity {

    private ListView listeDesVilles;
    private Switch listeFavoris;
    static String[]  lesVilles = {"ville1","ville2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_villes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,lesVilles);

        //liste des villes
        listeDesVilles = (ListView) findViewById(R.id.listeVille);
        listeDesVilles.setAdapter(adapter);
        listeDesVilles.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onVilleChoisieClick(i);
            }
        });

        //liste des favoris
        listeFavoris = (Switch) findViewById(R.id.favoris);
        listeFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeListToFavoris(view);
            }
        });
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
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onVilleChoisieClick(int position){
        Intent intent = new Intent(this,VilleActivity.class);
        intent.putExtra("nomville",listeDesVilles.getItemAtPosition(position).toString());
        startActivity(intent);
    }

    public void changeListToFavoris(View view){
        if(listeFavoris.isChecked())
        {
            //TO DO update listeVille
        }
    }
}
