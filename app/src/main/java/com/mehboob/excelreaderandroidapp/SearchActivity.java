package com.mehboob.excelreaderandroidapp;


import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.mehboob.excelreaderandroidapp.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {


    private ArrayList<ExcelDataModel> list;
    private ArrayList<ExcelDataModel> filteredList;
    private ActivitySearchBinding binding;
    private SearchAdapter adapter;
    private ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        filteredList = new ArrayList<>(list);


        list.add(new ExcelDataModel(1, "Word", "Scamper", "run with light steps out of fear or excitement", "The mouse scampered away from the cat into its hole.", "Casual", 0, 5));
        list.add(new ExcelDataModel(10, "Idiom", "Proof of the pudding is in smth", "Real essence of smth is in smth different", "The proof of the pudding was in the taste of the cake and it was delicious.", "", 0, 0));
        list.add(new ExcelDataModel(20, "Phrase", "Hob-nobbing", "mix socially, especially with those of perceived higher social status", "The elite of the society were hob-nobbing at the exclusive event.", "Business", 0, 0));


        list.add(new ExcelDataModel(11, "Idiom", "Not Out of the woods", "not yet out of a difficult situation", "Although they have been trying for a year, they are still not out of the woods and need more help.", "", 0, 0));
        list.add(new ExcelDataModel(21, "Phrase", "Shilly shallying", "indecisive behavior", "He was accused of shilly-shallying on the important decision for far too long.", "", 0, 0));

        list.add(new ExcelDataModel(3, "Word", "Gratis/pro bono", "without charge or fee", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable", "Casual", 0, 5));
        list.add(new ExcelDataModel(12, "Idiom", "Helter-skelter", "involving disorderly haste or confusion", "the helter-skelter of a school day", "", 0, 0));


        list.add(new ExcelDataModel(22, "Phrase", "Conjuring up", "", "The magician impressed the audience by conjuring up a rabbit out of nowhere.", "", 0, 0));

        list.add(new ExcelDataModel(2, "Word", "Short shrift", "little time between condemnation and execution or punishment", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable.", "", 5, 0));

        list.add(new ExcelDataModel(3, "Word", "Gratis/pro bono", "without charge or fee", "She was given the ticket gratis for being a member of the VIP club.", "", 3, 0));
        list.add(new ExcelDataModel(13, "Idiom", "Does not seem to hold water", "does not seem to stand the test of validity", "The argument he made does not seem to hold water, it's full of loopholes.", "", 2, 0));

        list.add(new ExcelDataModel(4, "Word", "Stultify", "cause to lose enthusiasm and initiative", "The long hours at work stultified his creativity and imagination.", "", 0, 0));
        list.add(new ExcelDataModel(23, "Phrase", "Silver Bullet", "a simple and seemingly magical solution to a complicated problem; used with negative connotation", "The company was searching for a silver bullet solution to their financial problems.", "", 0, 0));

        list.add(new ExcelDataModel(5, "Word", "Moribund", "(of a thing) in terminal decline; lacking vitality or vigour", "The industry was in a moribund state, with no new developments or progress in sight.", "Business", 2, 0));
        list.add(new ExcelDataModel(16, "Idiom", "At the turn of something", "describing things associated with something important about to happen", "At the turn of the year, he made a resolution to change his life for the better.", "", 0, 0));
        list.add(new ExcelDataModel(24, "Phrase", "Raised hackles", "to arouse someone's concerns", "The insensitive remark raised hackles among the employees and sparked a heated debate.", "", 0, 0));

        list.add(new ExcelDataModel(6, "Word", "Subvention", "a grant of money, especially from a government", "The government provided a subvention to support the struggling farmers.", "", 0, 0));
        list.add(new ExcelDataModel(7, "Word", "Subversion", "the undermining of the power and authority of an established system or institution", "The spy was caught trying to subvert the government's plans.", "Business", 0, 0));
        list.add(new ExcelDataModel(17, "Idiom", "To brush aside", "To not pay attention; ignore", "He tried to brush aside his fear and focus on the task at hand.", "", 0, 0));
        list.add(new ExcelDataModel(18, "Idiom", "Pass muster", "be accepted as adequate or satisfactory", "The proposal did not pass muster and was rejected by the board.", "", 0, 0));
        list.add(new ExcelDataModel(8, "Word", "Hard nosed", "Realistic and determined", "He was known for his hard-nosed negotiating style, never giving an inch.", "", 0, 0));
        list.add(new ExcelDataModel(9, "Word", "Latitude", "scope for freedom of action or thought", "The employees were given latitude in how they accomplished their tasks, as long as the results were good.", "Sports", 3, 0));
        list.add(new ExcelDataModel(26, "Phrase", "Raft of changes", "", "The company announced a raft of changes to its operations to improve its competitiveness.", "", 0, 0));


        list.add(new ExcelDataModel(19, "Idiom", "Lead the wolf pack", "Lead a gang of aggressive entities", "He was the one who led the wolf pack and inspired the others to follow.", "", 0, 0));

        list.add(new ExcelDataModel(25, "Phrase", "Arm twisting", "", "The manager resorted to arm-twisting tactics to get the employees to comply with his demands.", "", 0, 0));
        list.add(new ExcelDataModel(27, "Phrase", "Tongues wagging", "Chk Tongue Lashing", "The news of the celebrity divorce had tongues wagging in the entertainment industry.", "", 0, 0));

        adapter = new SearchAdapter(list,this);
       binding.listView.setAdapter(adapter);

       binding.listView.setLayoutManager(new LinearLayoutManager(this));






        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.noData.setVisibility(View.GONE);
                binding.listView.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (binding.etSearch.getText().toString().length() == 0) {
                    binding.noData.setVisibility(View.VISIBLE);
                    binding.listView.setVisibility(View.GONE);
                    if (adapter != null) {
                        adapter.filter("");
                    }
                } else {
                    String text = binding.etSearch.getText().toString().toLowerCase(Locale.getDefault());
                    binding.noData.setVisibility(View.GONE);
                    binding.listView.setVisibility(View.VISIBLE);
                    if (adapter != null) {
                        adapter.filter(text);
                    }
                }

            }
        });


    }




}