package com.mehboob.excelreaderandroidapp;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

// Inside your DAO interface (e.g., ExcelDataDao.java)
@Dao
public interface ExcelDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DataModel excelDataModel);

    @Update
    void update(DataModel excelDataModel);

    @Query("SELECT * FROM excel_data WHERE sr = :itemId")
    DataModel getById(int itemId);

    // Add other queries as needed
}
