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

    private void saveWord(String word){

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(FILTER_WORD,word);
        editor.apply();
        editor.commit();
    }

    public String fetchWord(){

        return preferences.getString(FILTER_WORD,"");
    }
}
