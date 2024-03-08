package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FilterActivity extends AppCompatActivity {
    private CheckBox checkBoxWord, checkBoxPhrases, checkBoxIdioms,
            checkBoxBusiness, checkBoxSports, checkBoxCasual;

    private SharedPreferences sharedPreferences;

    private Set<String> selectedFilters;
    private Button btnApplyFilter, btnClearFilters;
    public SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        // Initialize CheckBoxes
        checkBoxWord = findViewById(R.id.radioButtonWord);
        checkBoxPhrases = findViewById(R.id.radioButtonPhrases);
        checkBoxIdioms = findViewById(R.id.radioButtonIdioms);
        checkBoxBusiness = findViewById(R.id.radioButtonBusiness);
        checkBoxSports = findViewById(R.id.radioButtonSports);
        checkBoxCasual = findViewById(R.id.radioButtonCasual);
        sharedPref= new SharedPref(this);

        // Initialize SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        // Load previously selected filters
        loadFilters();

        // Set onClickListener for Apply Filter button
        Button btnApplyFilter = findViewById(R.id.btnApplyFilter);
        btnApplyFilter.setOnClickListener(view -> applyFilters());

        // Set onClickListener for Clear Filters button
        Button btnClearFilters = findViewById(R.id.btnClearFilters);
        btnClearFilters.setOnClickListener(view -> clearFilters());
    }

    private void loadFilters() {
        selectedFilters = sharedPreferences.getStringSet("selectedFilters", new HashSet<>());

        checkBoxWord.setChecked(sharedPref.fetchWord());
        checkBoxPhrases.setChecked(sharedPref.fetchPhrase());
        checkBoxIdioms.setChecked(sharedPref.fetchIdom());

        checkBoxBusiness.setChecked(sharedPref.fetchBusiness());
        checkBoxSports.setChecked(sharedPref.fetchSports());
        checkBoxCasual.setChecked(sharedPref.fetchCasual());



    }

    private void applyFilters() {
        // Update selected filters set

        sharedPref.saveWord(checkBoxWord.isChecked());
        sharedPref.savePhrase(checkBoxPhrases.isChecked());
        sharedPref.saveIdom(checkBoxIdioms.isChecked());
        sharedPref.saveBusiness(checkBoxBusiness.isChecked());
        sharedPref.saveSports(checkBoxSports.isChecked());
        sharedPref.saveCasual(checkBoxCasual.isChecked());



        Toast.makeText(this, "Filters Applied!", Toast.LENGTH_SHORT).show();
    }

    private void clearFilters() {
        // Clear the selected filters in SharedPreferences
        sharedPref.clearPref();

        // Clear the checkboxes
        checkBoxWord.setChecked(false);
        checkBoxPhrases.setChecked(false);
        checkBoxIdioms.setChecked(false);
        checkBoxBusiness.setChecked(false);
        checkBoxSports.setChecked(false);
        checkBoxCasual.setChecked(false);

        Toast.makeText(this, "Filters Cleared!", Toast.LENGTH_SHORT).show();
    }
}