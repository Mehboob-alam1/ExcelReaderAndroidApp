package com.mehboob.excelreaderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mehboob.excelreaderandroidapp.databinding.ActivityWordDetailBinding;

import java.lang.reflect.Type;

public class WordDetailActivity extends AppCompatActivity {


    private ActivityWordDetailBinding binding;

    private String data;
    private DataModel dataGet;
    private int itemId;
    int newCount;
    private ExcelDataViewModel excelDataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWordDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        excelDataViewModel = new ViewModelProvider(this).get(ExcelDataViewModel.class);


        data=getIntent().getStringExtra("data");




        binding.imgBack.setOnClickListener(v -> {
            finish();
        });

        Type dataType = new TypeToken<DataModel>() {}.getType();
        Gson gson = new Gson();
         dataGet = gson.fromJson(data, dataType);

         itemId=dataGet.getSr();



        Toast.makeText(this, ""+itemId, Toast.LENGTH_SHORT).show();

        binding.btnUpdate.setOnClickListener(v -> {


            if (binding.etReadCount.getText().toString().isEmpty()){
                Toast.makeText(this, "Can't be empty", Toast.LENGTH_SHORT).show();
            }else{


                excelDataViewModel.updateReadCount(itemId,Integer.parseInt(binding.etReadCount.getText().toString()));
            }
        });

         binding.txtWord.setText(dataGet.getWip());
         binding.txtMeaning.setText(dataGet.getMeaning());
         binding.txtSampleSentence.setText(dataGet.getSampleSentence());
//         binding.etReadCount.setText(dataGet.getReadCount() +"");
//         binding.txtViewCount.setText(dataGet.getDisplayCount() + " times");




    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        excelDataViewModel.getData(itemId).observe(this,dataModel -> {

            Log.d("NewData",dataModel.toString());

            if (dataModel!=null) {




                newCount=    dataModel.getDisplayCount()+1;



                binding.etReadCount.setText(dataModel.getReadCount() + "");
                binding.txtViewCount.setText(dataModel.getDisplayCount() + " times");

                excelDataViewModel.getData(itemId).removeObservers(this);

//                Toast.makeText(this, ""+dataModel.toString(), Toast.LENGTH_LONG).show();
            }
        });
        excelDataViewModel.updateDisplayCount(itemId,newCount);



    }
}