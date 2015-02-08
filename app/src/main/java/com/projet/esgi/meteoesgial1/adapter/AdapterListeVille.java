package com.projet.esgi.meteoesgial1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.projet.esgi.meteoesgial1.R;
import com.projet.esgi.meteoesgial1.modele.Ville;

import java.util.ArrayList;

public class AdapterListeVille extends ArrayAdapter<Ville> {

    public AdapterListeVille (Context context,ArrayList<Ville> listVille){
        super(context, 0, listVille);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
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
        // Return the completed view to render on screen
        return convertView;
    }
}
