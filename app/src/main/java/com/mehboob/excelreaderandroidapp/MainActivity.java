package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mehboob.excelreaderandroidapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<ExcelDataModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list= new ArrayList<>();


        list.add(new ExcelDataModel(1,"Word","Scamper","run with light steps out of fear or excitement","The mouse scampered away from the cat into its hole.","Casual",0,5));
        list.add(new ExcelDataModel(2,"Word","Short shrift","little time between condemnation and execution or punishment","He gave short shrift to the idea of starting a new business, dismissing it as unprofitable","Casual",0,5));
        list.add(new ExcelDataModel(3,"Word","Scamper","run with light steps out of fear or excitement","The mouse scampered away from the cat into its hole.","Casual",0,5));
        list.add(new ExcelDataModel(4,"Word","Scamper","run with light steps out of fear or excitement","The mouse scampered away from the cat into its hole.","Casual",0,5));
        list.add(new ExcelDataModel(5,"Word","Scamper","run with light steps out of fear or excitement","The mouse scampered away from the cat into its hole.","Casual",0,5));


        setRecyclerView();


    }

    private void setRecyclerView() {

        Adapter adapter = new Adapter(this, list);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }
}