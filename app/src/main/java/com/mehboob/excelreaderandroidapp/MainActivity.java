package com.mehboob.excelreaderandroidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SearchView;

import com.mehboob.excelreaderandroidapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<ExcelDataModel> list;
    private ArrayList<ExcelDataModel> filteredList;
    private static final int FILTER_REQUEST_CODE = 1;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();
        filteredList = new ArrayList<>(list);


        list.add(new ExcelDataModel(1, "Word", "Scamper", "run with light steps out of fear or excitement", "The mouse scampered away from the cat into its hole.", "Casual", 0, 5));
        list.add(new ExcelDataModel(2, "Word", "Short shrift", "little time between condemnation and execution or punishment", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable", "Casual", 0, 5));
        list.add(new ExcelDataModel(3, "Word", "Gratis/pro bono", "without charge or fee", "He gave short shrift to the idea of starting a new business, dismissing it as unprofitable", "Casual", 0, 5));


        setRecyclerView();
        binding.imgFilter.setOnClickListener(v -> startFilterActivity());

binding.imgImportExport.setOnClickListener(v -> {
    showOptionsPopup();
});
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String query) {
        if (TextUtils.isEmpty(query)) {
            // If the query is empty, show the entire list
            filteredList.clear();
            filteredList.addAll(list);
        } else {
            // Filter the list based on the query
            filteredList.clear();
            for (ExcelDataModel data : list) {
                if (data.getWip().toLowerCase().contains(query.toLowerCase()) ||
                        data.getMeaning().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(data);
                }
            }
        }

        // Notify the adapter about the changes
        adapter.setList(filteredList);
        adapter.notifyDataSetChanged();
    }


    private void startFilterActivity() {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivityForResult(intent, FILTER_REQUEST_CODE);
    }

    private void setRecyclerView() {

        adapter = new Adapter(this, list);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILTER_REQUEST_CODE && resultCode == RESULT_OK) {
            // Retrieve the filtered list from the data intent


            assert data != null;
            ArrayList<ExcelDataModel> filteredList = data.getParcelableArrayListExtra(FilterActivity.EXTRA_FILTERED_LIST);

            // Update the main list and notify the adapter
            adapter.setList(filteredList);
            adapter.notifyDataSetChanged();
        }
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

}