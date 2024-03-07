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
import java.util.Set;

public class FilterActivity extends AppCompatActivity {
    private CheckBox checkBoxWord, checkBoxPhrases, checkBoxIdioms,
            checkBoxBusiness, checkBoxSports, checkBoxCasual;

    private SharedPreferences sharedPreferences;

    private Set<String> selectedFilters;
    private Button btnApplyFilter, btnClearFilters;

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

        // Initialize SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        // Load previously selected filters
        loadFilters();

        // Set onClickListener for Apply Filter button
        Button btnApplyFilter = findViewById(R.id.btnApplyFilter);
        btnApplyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyFilters();
            }
        });

        // Set onClickListener for Clear Filters button
        Button btnClearFilters = findViewById(R.id.btnClearFilters);
        btnClearFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFilters();
            }
        });
    }

    private void loadFilters() {
        selectedFilters = sharedPreferences.getStringSet("selectedFilters", new HashSet<>());

        // Update checkboxes based on the loaded filters
        checkBoxWord.setChecked(selectedFilters.contains("Word"));
        checkBoxPhrases.setChecked(selectedFilters.contains("Phrase"));
        checkBoxIdioms.setChecked(selectedFilters.contains("Idiom"));
        checkBoxBusiness.setChecked(selectedFilters.contains("Business"));
        checkBoxSports.setChecked(selectedFilters.contains("Sports"));
        checkBoxCasual.setChecked(selectedFilters.contains("Casual"));
    }

    private void applyFilters() {
        // Update selected filters set
        selectedFilters.clear();
        if (checkBoxWord.isChecked()) selectedFilters.add("Word");
        if (checkBoxPhrases.isChecked()) selectedFilters.add("Phrase");
        if (checkBoxIdioms.isChecked()) selectedFilters.add("Idiom");
        if (checkBoxBusiness.isChecked()) selectedFilters.add("Business");
        if (checkBoxSports.isChecked()) selectedFilters.add("Sports");
        if (checkBoxCasual.isChecked()) selectedFilters.add("Casual");

        // Save the selected filters in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("selectedFilters", selectedFilters);
        editor.apply();
        editor.commit();

        // You can now use the selected filters for your filtering logic
        // For example, you might want to retrieve the values later using:
        // Set<String> selectedFilters = sharedPreferences.getStringSet("selectedFilters", new HashSet<>());
        // ... and use 'selectedFilters' in your filtering logic

        Toast.makeText(this, "Filters Applied!", Toast.LENGTH_SHORT).show();
    }

    private void clearFilters() {
        // Clear the selected filters in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("selectedFilters");
        editor.apply();

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