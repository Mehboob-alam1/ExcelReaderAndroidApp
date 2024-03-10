package com.mehboob.excelreaderandroidapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// ExcelDataViewModel.java
public class ExcelDataViewModel extends AndroidViewModel {

    private ExcelRepo repository;

    public ExcelDataViewModel(@NonNull Application application) {
        super(application);
        repository = new ExcelRepo(application);
    }

    // Method to get LiveData for all ExcelData
    public LiveData<List<DataModel>> getAllExcelData() {

        return repository.getAllExcelData();
    }

    // Method to update the view count
    public void updateReadCount(int itemId,int readCount) {
        repository.updateReadCount(itemId,readCount);
    }
    public void updateDisplayCount(int itemId,int newCOunt){
        repository.updateDisplayCounts(itemId,newCOunt);
    }

    public LiveData<DataModel> getData(int itemId){

        return repository.getDataModel(itemId);
    }

    public void insertData(List<DataModel> dataModels){
        repository.insertData(dataModels);
    }
}
