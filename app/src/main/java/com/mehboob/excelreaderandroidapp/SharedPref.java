package com.mehboob.excelreaderandroidapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {


    private SharedPreferences preferences;
    private static final String FILTER_WORD="word_filter";
    private static final String FILTER_PHRASE="phrase_filter";
    private static final String FILTER_IDIOM="idiom_filter";
    private static final String FILTER_BUSINESS="business_filter";
    private static final String FILTER_SPORTS="sports_filter";
    private static final String FILTER_CASUAL="casual_filter";

    public SharedPref(Context context) {

        preferences= context.getSharedPreferences(FILTER_WORD,Context.MODE_PRIVATE);
        preferences= context.getSharedPreferences(FILTER_PHRASE,Context.MODE_PRIVATE);
        preferences= context.getSharedPreferences(FILTER_IDIOM,Context.MODE_PRIVATE);
        preferences= context.getSharedPreferences(FILTER_BUSINESS,Context.MODE_PRIVATE);
        preferences= context.getSharedPreferences(FILTER_SPORTS,Context.MODE_PRIVATE);
        preferences= context.getSharedPreferences(FILTER_CASUAL,Context.MODE_PRIVATE);
    }

    public void saveWord(boolean isChecked){

        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(FILTER_WORD,isChecked);
        editor.apply();
        editor.commit();
    }

    public boolean fetchWord(){

        return preferences.getBoolean(FILTER_WORD,false);
    }

    public void savePhrase(boolean isChecked){

        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(FILTER_PHRASE,isChecked);
        editor.apply();
        editor.commit();
    }

    public boolean  fetchPhrase(){

        return preferences.getBoolean(FILTER_PHRASE,false);
    }

    public void saveIdom(boolean isChecked){
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(FILTER_IDIOM,isChecked);
        editor.apply();
        editor.commit();
    }

    public boolean fetchIdom(){
        return  preferences.getBoolean(FILTER_IDIOM,false);
    }

    public void saveBusiness(boolean isChecked){
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(FILTER_BUSINESS,isChecked);
        editor.apply();
        editor.commit();
    }
    public boolean fetchBusiness(){

        return preferences.getBoolean(FILTER_BUSINESS,false);
    }

    public void saveSports(boolean isChecked){

        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(FILTER_SPORTS,isChecked);
        editor.apply();
        editor.commit();
    }
    public boolean fetchSports(){

        return preferences.getBoolean(FILTER_SPORTS,false);
    }

    public void saveCasual(boolean isChecked){

        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(FILTER_CASUAL,isChecked);
        editor.apply();
        editor.commit();
    }


    public boolean fetchCasual(){
        return preferences.getBoolean(FILTER_CASUAL,false);
    }


    public void clearPref(){
        SharedPreferences.Editor editor=preferences.edit();
        editor.remove(FILTER_PHRASE);
        editor.remove(FILTER_WORD);
        editor.remove(FILTER_IDIOM);
        editor.remove(FILTER_BUSINESS);
        editor.remove(FILTER_SPORTS);
        editor.remove(FILTER_CASUAL);
        editor.apply();


    }

}
