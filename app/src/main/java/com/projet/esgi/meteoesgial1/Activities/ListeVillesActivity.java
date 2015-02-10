package com.projet.esgi.meteoesgial1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;

import com.projet.esgi.meteoesgial1.MeteoApplication;
import com.projet.esgi.meteoesgial1.R;
import com.projet.esgi.meteoesgial1.adapter.AdapterListeVille;
import com.projet.esgi.meteoesgial1.modele.Ville;

import java.util.ArrayList;


public class ListeVillesActivity extends Activity {

    private ListView listeDesVilles;
    private Switch switchFavoris;
    private SearchView rechercheVilleListe;

    private static ArrayList<Ville> lesVilles = new ArrayList<Ville>();
    private static ArrayList<Ville> lesVillesFavoris = new ArrayList<Ville>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_villes);

        //DEBUG
        lesVilles = ((MeteoApplication)getApplication()).getLesVilles();
        initListVille(lesVilles);

        lesVillesFavoris= ((MeteoApplication)getApplication()).getLesVillesFavoris();

        initFavoris();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_liste_villes, menu);

        initSearchView(menu);

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
        Bundle bundle = new Bundle();
        bundle.putSerializable("ville", (java.io.Serializable) listeDesVilles.getItemAtPosition(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void changeListToFavoris(View view){
        if(switchFavoris.isChecked())
        {
            initListVille(lesVillesFavoris);
        }
        else
        {
            initListVille(lesVilles);
        }
    }

    public void initListVille (ArrayList<Ville> listeVilles){
        AdapterListeVille adapterVille = new AdapterListeVille(this,listeVilles);

        //liste des villes
        listeDesVilles = (ListView) findViewById(R.id.listeVille);
        listeDesVilles.setAdapter(adapterVille);
        listeDesVilles.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onVilleChoisieClick(i);
            }
        });
    }

    public void initFavoris(){
        //liste des favoris
        switchFavoris = (Switch) findViewById(R.id.favoris);
        switchFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeListToFavoris(view);
            }
        });
    }

    private void initSearchView(Menu menu) {
        rechercheVilleListe = (SearchView) findViewById(R.id.rechercherVille);
        rechercheVilleListe.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Fetch the data remotely
                searchVille(query);
                // Reset SearchView
                rechercheVilleListe.clearFocus();
                rechercheVilleListe.setQuery("", false);
                rechercheVilleListe.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void searchVille(String nom){
        lesVilles.add(new Ville("VilleRecherche"));
        initListVille(lesVilles);
    }
}
