package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mehboob.excelreaderandroidapp.databinding.ActivityWordDetailBinding;

public class WordDetailActivity extends AppCompatActivity {


    private ActivityWordDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWordDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}