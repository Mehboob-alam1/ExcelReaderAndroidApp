package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mehboob.excelreaderandroidapp.databinding.ActivityWordDetailBinding;

import java.lang.reflect.Type;

public class WordDetailActivity extends AppCompatActivity {


    private ActivityWordDetailBinding binding;
    private ExcelDataDao excelDataDao;

    private String data;
    private ExcelDataModel dataGet;
    private int itemId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWordDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        excelDataDao = AppDatabase.getInstance(this).excelDataDao();


        data=getIntent().getStringExtra("data");



        binding.imgBack.setOnClickListener(v -> {
            finish();
        });

        Type dataType = new TypeToken<ExcelDataModel>() {}.getType();
        Gson gson = new Gson();
         dataGet = gson.fromJson(data, dataType);

         itemId=dataGet.getSr();



         binding.txtWord.setText(dataGet.getWip());
         binding.txtMeaning.setText(dataGet.getMeaning());
         binding.txtSampleSentence.setText(dataGet.getSampleSentence());
         binding.etReadCount.setText(dataGet.getReadCount() +" times");
         binding.txtViewCount.setText(dataGet.getDisplayCount() + " times");


        updateViewCount(dataGet.getSr());
        displayViewCount();
        displayReadCount();


        binding.btnUpdate.setOnClickListener(v -> {


            if (binding.etReadCount.getText().toString().isEmpty()){
                Toast.makeText(this, "Can't be empty", Toast.LENGTH_SHORT).show();
            }else{

                updateReadCount(Integer.parseInt(binding.etReadCount.getText().toString()));
                displayReadCount();
            }
        });
    }

    private void updateViewCount(int itemId) {
        DataModel dataModel = excelDataDao.getById(itemId);
        if (dataModel != null) {
            dataModel.setDisplayCount(dataModel.getDisplayCount() + 1);
            excelDataDao.update(dataModel);
        }
    }



    private void displayViewCount() {
        DataModel dataModel = excelDataDao.getById(itemId);
        if (dataModel != null) {
            int viewCount = dataModel.getDisplayCount();
            binding.txtViewCount.setText(viewCount + " times");
        }
    }

    // Add this method to update the read count in Room database
    private void updateReadCount(int newReadCount) {
       DataModel dataModel = excelDataDao.getById(itemId);
        if (dataModel != null) {
            dataModel.setReadCount(newReadCount);
            excelDataDao.update(dataModel);
        }
    }

    // Add this method to get and display the read count
    private void displayReadCount() {
        DataModel dataModel = excelDataDao.getById(itemId);
        if (dataModel != null) {
            int readCount = dataModel.getReadCount();
          binding.etReadCount.setText(readCount+"");
        }
    }
}