package com.projet.esgi.meteoesgial1;

import android.app.Application;

import com.projet.esgi.meteoesgial1.modele.Ville;

import java.util.ArrayList;

public class MeteoApplication extends Application{
    private static ArrayList<Ville> lesVilles = new ArrayList<Ville>();
    private static ArrayList<Ville> lesVillesFavoris = new ArrayList<Ville>();

    @Override
    public void onCreate() {
        super.onCreate();
        initListeVilles();
    }

    private void initListeVilles() {
        lesVilles.add(new Ville("London"));
        lesVilles.add(new Ville("Paris"));
        lesVilles.add(new Ville("Madrid"));
        lesVilles.add(new Ville("Berlin"));
        lesVilles.add(new Ville("Lisbon"));
        lesVilles.add(new Ville("Miami"));
        lesVilles.add(new Ville("Valognes"));
        lesVilles.add(new Ville("Montataire"));
        lesVilles.add(new Ville("Moscow"));
        lesVilles.add(new Ville("Stockholm"));
    }

    public ArrayList<Ville> getLesVilles(){
        return lesVilles;
    }
    public ArrayList<Ville> getLesVillesFavoris(){
        return lesVillesFavoris;
    }
}
