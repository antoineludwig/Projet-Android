package com.projet.esgi.meteoesgial1.adapter;




import android.content.Context;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;


import com.projet.esgi.meteoesgial1.Activities.ListeVillesActivity;
import com.projet.esgi.meteoesgial1.Activities.VilleActivity;




import com.projet.esgi.meteoesgial1.R;

import com.projet.esgi.meteoesgial1.modele.Ville;


import java.util.ArrayList;

public class AdapterListeVille extends ArrayAdapter<Ville> {

    public ListeVillesActivity listeVilleActivity;
    public  boolean isFavoris;

    public AdapterListeVille (Context context,ArrayList<Ville> listVille, ListeVillesActivity _listeVilleActivity,boolean _isFavoris){
        super(context, 0, listVille);
        listeVilleActivity = _listeVilleActivity;
        isFavoris = _isFavoris;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Ville ville = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemville, parent, false);
        }
        // Lookup view for data ville
        TextView tvName = (TextView) convertView.findViewById(R.id.nomItemVille);
        // Populate the data into the template view using the data object
        tvName.setText(ville.getNom());
        tvName.setTextSize(25);
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listeVilleActivity.onVilleChoisieClick(position);
            }
        });

        Button boutonSupp = (Button) convertView.findViewById(R.id.supprimer);
        if(isFavoris) {
            boutonSupp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listeVilleActivity.deleteVille(position);
                }
            });
        }else{
            boutonSupp.setVisibility(View.INVISIBLE);
        }


        // Return the completed view to render on screen
        return convertView;
    }


}
