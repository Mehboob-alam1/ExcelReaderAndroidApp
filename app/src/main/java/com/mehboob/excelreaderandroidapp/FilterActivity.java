package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {
    private ArrayList<ExcelDataModel> list;
    private ArrayList<ExcelDataModel> filteredList;
    private Adapter adapter;
    public static final String EXTRA_FILTERED_LIST = "extraFilteredList";

    private CheckBox checkboxWords, checkboxPhrases, checkboxIdioms,
            checkboxBusiness, checkboxSports, checkboxCasual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        list = new ArrayList<>(); // Initialize your list with data
        filteredList = new ArrayList<>(list);

        // Initialize your checkboxes and buttons
        checkboxWords = findViewById(R.id.checkboxWords);
        checkboxPhrases = findViewById(R.id.checkboxPhrases);
        checkboxIdioms = findViewById(R.id.checkboxIdioms);
        checkboxBusiness = findViewById(R.id.checkboxBusiness);
        checkboxSports = findViewById(R.id.checkboxSports);
        checkboxCasual = findViewById(R.id.checkboxCasual);

        Button btnApplyFilter = findViewById(R.id.btnApplyFilter);
        Button btnClearFilters = findViewById(R.id.btnClearFilters);

        // Apply filter button click listener
        btnApplyFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // applyFilters();
            }
        });

        // Clear filters button click listener
        btnClearFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  clearFilters();
            }
        });
    }


    private void applyFilters() {
        filteredList.clear();

        for (ExcelDataModel data : list) {
            if ((checkboxWords.isChecked() && data.getCategory().equals("Word")) ||
                    (checkboxPhrases.isChecked() && data.getCategory().equals("Phrase")) ||
                    (checkboxIdioms.isChecked() && data.getCategory().equals("Idiom")) ||
                    (checkboxBusiness.isChecked() && data.getCustomTag().equals("Business")) ||
                    (checkboxSports.isChecked() && data.getCustomTag().equals("Sports")) ||
                    (checkboxCasual.isChecked() && data.getCustomTag().equals("Casual"))) {
                filteredList.add(data);
            }
        }

        // Create an intent to send back the filtered list
        Intent resultIntent = new Intent();
        resultIntent.putParcelableArrayListExtra(EXTRA_FILTERED_LIST,new ArrayList<>(filteredList));

        // Set the result and finish the activity
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void clearFilters() {
        checkboxWords.setChecked(false);
        checkboxPhrases.setChecked(false);
        checkboxIdioms.setChecked(false);
        checkboxBusiness.setChecked(false);
        checkboxSports.setChecked(false);
        checkboxCasual.setChecked(false);

        filteredList.clear();
        filteredList.addAll(list);

        // Create an intent to send back the cleared list
        Intent resultIntent = new Intent();
        resultIntent.putParcelableArrayListExtra(EXTRA_FILTERED_LIST, (ArrayList<? extends Parcelable>) filteredList);

        // Set the result and finish the activity
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}