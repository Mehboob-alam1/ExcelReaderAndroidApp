package com.mehboob.excelreaderandroidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.mehboob.excelreaderandroidapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<ExcelDataModel> list;
    private List<ExcelDataModel> dataList;

    private ArrayList<ExcelDataModel> filteredList;
    private static final int FILTER_REQUEST_CODE = 1;
    private boolean isHorizontalOrientation = true;
    private SharedPreferences sharedPreferences;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        isHorizontalOrientation = sharedPreferences.getBoolean("isHorizontal", true);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        list = new ArrayList<>();
        filteredList = new ArrayList<>(list);


        list.add(new ExcelDataModel(1, "Word", "Scamper", "run with light steps out of fear or excitement", "The mouse scampered away from the cat into its hole.", "Casual", 0, 5));
        list.add(new ExcelDataModel(2, "Word", "Short shrift", "little time between condemnation and execution or punishment", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable", "Casual", 0, 5));
        list.add(new ExcelDataModel(3, "Word", "Gratis/pro bono", "without charge or fee", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable", "Casual", 0, 5));

        list.add(new ExcelDataModel(1, "Word", "Scamper", "run with light steps out of fear or excitement", "The mouse scampered away from the cat into its hole.", "Casual", 0, 0));
        list.add(new ExcelDataModel(2, "Word", "Short shrift", "little time between condemnation and execution or punishment", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable.", "", 5, 0));
        list.add(new ExcelDataModel(3, "Word", "Gratis/pro bono", "without charge or fee", "She was given the ticket gratis for being a member of the VIP club.", "", 3, 0));
        list.add(new ExcelDataModel(4, "Word", "Stultify", "cause to lose enthusiasm and initiative", "The long hours at work stultified his creativity and imagination.", "", 0, 0));
        list.add(new ExcelDataModel(5, "Word", "Moribund", "(of a thing) in terminal decline; lacking vitality or vigour", "The industry was in a moribund state, with no new developments or progress in sight.", "Business", 2, 0));
        list.add(new ExcelDataModel(6, "Word", "Subvention", "a grant of money, especially from a government", "The government provided a subvention to support the struggling farmers.", "", 0, 0));
        list.add(new ExcelDataModel(7, "Word", "Subversion", "the undermining of the power and authority of an established system or institution", "The spy was caught trying to subvert the government's plans.", "Business", 0, 0));
        list.add(new ExcelDataModel(8, "Word", "Hard nosed", "Realistic and determined", "He was known for his hard-nosed negotiating style, never giving an inch.", "", 0, 0));
        list.add(new ExcelDataModel(9, "Word", "Latitude", "scope for freedom of action or thought", "The employees were given latitude in how they accomplished their tasks, as long as the results were good.", "Sports", 3, 0));

        list.add(new ExcelDataModel(10, "Idiom", "Proof of the pudding is in smth", "Real essence of smth is in smth different", "The proof of the pudding was in the taste of the cake and it was delicious.", "", 0, 0));
        list.add(new ExcelDataModel(11, "Idiom", "Not Out of the woods", "not yet out of a difficult situation", "Although they have been trying for a year, they are still not out of the woods and need more help.", "", 0, 0));
        list.add(new ExcelDataModel(12, "Idiom", "Helter-skelter", "involving disorderly haste or confusion", "the helter-skelter of a school day", "", 0, 0));
        list.add(new ExcelDataModel(13, "Idiom", "Does not seem to hold water", "does not seem to stand the test of validity", "The argument he made does not seem to hold water, it's full of loopholes.", "", 2, 0));
        list.add(new ExcelDataModel(16, "Idiom", "At the turn of something", "describing things associated with something important about to happen", "At the turn of the year, he made a resolution to change his life for the better.", "", 0, 0));
        list.add(new ExcelDataModel(17, "Idiom", "To brush aside", "To not pay attention; ignore", "He tried to brush aside his fear and focus on the task at hand.", "", 0, 0));
        list.add(new ExcelDataModel(18, "Idiom", "Pass muster", "be accepted as adequate or satisfactory", "The proposal did not pass muster and was rejected by the board.", "", 0, 0));
        list.add(new ExcelDataModel(19, "Idiom", "Lead the wolf pack", "Lead a gang of aggressive entities", "He was the one who led the wolf pack and inspired the others to follow.", "", 0, 0));

        list.add(new ExcelDataModel(20, "Phrase", "Hob-nobbing", "mix socially, especially with those of perceived higher social status", "The elite of the society were hob-nobbing at the exclusive event.", "Business", 0, 0));
        list.add(new ExcelDataModel(21, "Phrase", "Shilly shallying", "indecisive behavior", "He was accused of shilly-shallying on the important decision for far too long.", "", 0, 0));
        list.add(new ExcelDataModel(22, "Phrase", "Conjuring up", "", "The magician impressed the audience by conjuring up a rabbit out of nowhere.", "", 0, 0));
        list.add(new ExcelDataModel(23, "Phrase", "Silver Bullet", "a simple and seemingly magical solution to a complicated problem; used with negative connotation", "The company was searching for a silver bullet solution to their financial problems.", "", 0, 0));
        list.add(new ExcelDataModel(24, "Phrase", "Raised hackles", "to arouse someone's concerns", "The insensitive remark raised hackles among the employees and sparked a heated debate.", "", 0, 0));
        list.add(new ExcelDataModel(25, "Phrase", "Arm twisting", "", "The manager resorted to arm-twisting tactics to get the employees to comply with his demands.", "", 0, 0));
        list.add(new ExcelDataModel(26, "Phrase", "Raft of changes", "", "The company announced a raft of changes to its operations to improve its competitiveness.", "", 0, 0));
        list.add(new ExcelDataModel(27, "Phrase", "Tongues wagging", "Chk Tongue Lashing", "The news of the celebrity divorce had tongues wagging in the entertainment industry.", "", 0, 0));


        setRecyclerView(isHorizontalOrientation);

        binding.textVertical.setOnClickListener(v -> {
            isHorizontalOrientation = !isHorizontalOrientation;
            setRecyclerView(isHorizontalOrientation);

            saveOrientationPreference(isHorizontalOrientation);
        });
        binding.imgFilter.setOnClickListener(v -> startFilterActivity());

        binding.imgImportExport.setOnClickListener(v -> {
            showOptionsPopup();
        });

        binding.imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
        if (sharedPreferences != null) {

            loadAndApplyFilters();
        }

    }


    private void startFilterActivity() {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivityForResult(intent, FILTER_REQUEST_CODE);
    }

    private void saveOrientationPreference(boolean isHorizontal) {
        // Save the orientation preference in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isHorizontal", isHorizontal);
        editor.apply();
    }

    private void loadAndApplyFilters() {
        // Load filter preferences and apply filters
        String selectedCategory = sharedPreferences.getString("selected_category", null);
        String selectedTag = sharedPreferences.getString("selected_tag", null);

        Log.d("FilterM", selectedCategory + " ");
        Log.d("FilterM", selectedTag + " ");
        // Apply filters if preferences are set
        if (selectedCategory != null && selectedTag != null) {
            applyFilter(selectedCategory, selectedTag);
        }
    }

    private void applyFilter(String selectedCategory, String selectedTag) {
        // Filter the list based on the selected category and tag
        filteredList.clear();
        for (ExcelDataModel data : list) {
            if (data != null) {
                if (data.getCategory().equals(selectedCategory) && data.getCustomTag().equals(selectedTag)) {
                    Log.d("Filter", selectedCategory + " Equal " + data.getCategory());
                    Log.d("Filter", selectedTag + " Equal " + data.getCustomTag());
                    filteredList.add(data);
                }
            }

        }

        // Update the RecyclerView with the filtered list
        adapter.setList(filteredList);
        adapter.notifyDataSetChanged();
    }


    private void showOptionsPopup() {
        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select an Option");

        // Add options to the dialog
        builder.setItems(new CharSequence[]{"Import WIP", "Export WIP"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle the selected option
                switch (which) {
                    case 0:
                        // Import WIP option selected
                        // Implement your import logic here
                        break;
                    case 1:
                        // Export WIP option selected
                        // Implement your export logic here
                        break;
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setRecyclerView(boolean isHorizontal) {
        LinearLayoutManager layoutManager;

        if (isHorizontal) {
            // Set the layout manager to horizontal
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        } else {
            // Set the layout manager to vertical
            layoutManager = new LinearLayoutManager(this);
        }

        adapter = new Adapter(this, list);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

}