package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mehboob.excelreaderandroidapp.databinding.ActivityWordDetailBinding;

import java.lang.reflect.Type;

public class WordDetailActivity extends AppCompatActivity {


    private ActivityWordDetailBinding binding;

    private String data;
    private ExcelDataModel dataGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWordDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        data=getIntent().getStringExtra("data");

        binding.imgBack.setOnClickListener(v -> {
            finish();
        });

        Type dataType = new TypeToken<ExcelDataModel>() {}.getType();
        Gson gson = new Gson();
         dataGet = gson.fromJson(data, dataType);

         binding.txtWord.setText(dataGet.getWip());
         binding.txtMeaning.setText(dataGet.getMeaning());
         binding.txtSampleSentence.setText(dataGet.getSampleSentence());
         binding.txtReadCount.setText(dataGet.getReadCount() +" times");
         binding.txtViewCount.setText(dataGet.getDisplayCount() + " times");
    }
}