package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private RadioGroup radioGroupCategory, radioGroupTags;
    private RadioButton radioButtonWord, radioButtonPhrases, radioButtonIdioms,
            radioButtonBusiness, radioButtonCasual, radioButtonSports;
    private Button btnApplyFilter, btnClearFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);



        // Initialize your radio groups and buttons
        radioGroupCategory = findViewById(R.id.radioGroupCategory);
        radioGroupTags = findViewById(R.id.radioGroupTags);

        radioButtonWord = findViewById(R.id.radioButtonWord);
        radioButtonPhrases = findViewById(R.id.radioButtonPhrases);
        radioButtonIdioms = findViewById(R.id.radioButtonIdioms);

        radioButtonBusiness = findViewById(R.id.radioButtonBusiness);
        radioButtonCasual = findViewById(R.id.radioButtonCasual);
        radioButtonSports = findViewById(R.id.radioButtonSports);

        btnApplyFilter = findViewById(R.id.btnApplyFilter);
        btnClearFilters = findViewById(R.id.btnClearFilters);

        // Apply filter button click listener
        btnApplyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyFilters();
            }
        });

        // Clear filters button click listener
        btnClearFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFilters();
            }
        });

        loadFilterPreferences();

    }

    private void applyFilters() {
        int selectedCategoryRadioButtonId = radioGroupCategory.getCheckedRadioButtonId();
        int selectedTagRadioButtonId = radioGroupTags.getCheckedRadioButtonId();

        // Get the selected values from radio buttons
        String selectedCategory = getSelectedRadioButtonText(selectedCategoryRadioButtonId);
        String selectedTag = getSelectedRadioButtonText(selectedTagRadioButtonId);

        // Save the selected values to SharedPreferences
        saveFilterPreferences(selectedCategory, selectedTag);

        // Create an intent to send back the filtered list
        finish();

    }

    private void clearFilters() {
        saveFilterPreferences(null, null);

        // Uncheck all radio buttons
        radioGroupCategory.clearCheck();
        radioGroupTags.clearCheck();

        // Create an intent to send back the cleared list

        // You can pass other relevant data if needed

        finish();
    }

    private void saveFilterPreferences(String selectedCategory, String selectedTag) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("selected_category", selectedCategory);
        editor.putString("selected_tag", selectedTag);
        editor.apply();
    }

    private void loadFilterPreferences() {
        // Load saved filter preferences and set radio buttons accordingly
        String selectedCategory = sharedPreferences.getString("selected_category", null);
        String selectedTag = sharedPreferences.getString("selected_tag", null);

        // Check the radio button based on loaded preferences
        checkRadioButtonByText(radioGroupCategory, selectedCategory);
        checkRadioButtonByText(radioGroupTags, selectedTag);
    }

    private void checkRadioButtonByText(RadioGroup radioGroup, String text) {
        if (text != null) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                if (radioButton.getText().toString().equalsIgnoreCase(text)) {
                    radioButton.setChecked(true);
                    break;
                }
            }
        }
    }

    private String getSelectedRadioButtonText(int radioButtonId) {
        RadioButton radioButton = findViewById(radioButtonId);
        return radioButton != null ? radioButton.getText().toString() : null;
    }

}