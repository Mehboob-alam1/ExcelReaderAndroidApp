package com.mehboob.excelreaderandroidapp;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Inside your DAO interface (e.g., ExcelDataDao.java)
@Dao
public interface ExcelDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<DataModel> excelDataModel);

    @Update
    void update(DataModel excelDataModel);


    @Query("UPDATE excel_data SET readCount = :readCount WHERE sr = :itemId")
    void updateReadCount(int itemId, int readCount);

    @Query("UPDATE excel_data SET displayCount = :displayCount  WHERE sr = :itemId")
    void updateDisplayCount(int itemId,int displayCount);
    @Query("SELECT * FROM excel_data WHERE sr = :itemId")
    LiveData<DataModel> getById(int itemId);

    @Query("SELECT * FROM excel_data")
    LiveData<List<DataModel>> getAll();

}
