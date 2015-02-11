package com.projet.esgi.meteoesgial1;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.projet.esgi.meteoesgial1.modele.Ville;

import java.util.ArrayList;

public class MeteoApplication extends Application{
    private static ArrayList<Ville> lesVilles = new ArrayList<Ville>();
    private static ArrayList<Ville> lesVillesFavoris = new ArrayList<Ville>();
    private static final String PREF_FILE_NAME = "prefs";

    @Override
    public void onCreate() {
        super.onCreate();
        initListeVilles();
        initListeVillesFavoris();
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
    public void initListeVillesFavoris() {
        lesVillesFavoris.clear();
        SharedPreferences pref = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
        for (Ville v : lesVilles){
            if(pref.contains(v.getNom())){
                v.setFavoris(true);
                lesVillesFavoris.add(v);
            }
        }
    }

    public ArrayList<Ville> getLesVilles(){
        return lesVilles;
    }
    public ArrayList<Ville> getLesVillesFavoris(){
        return lesVillesFavoris;
    }

    public void addFavoris(Ville v){
        SharedPreferences pref = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
        pref.edit().putString(v.getNom(),v.getNom()).commit();
        initListeVillesFavoris();
    }

    public void removeFavoris(Ville v){
        SharedPreferences pref = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
        pref.edit().remove(v.getNom()).commit();
        initListeVillesFavoris();
    }
}
