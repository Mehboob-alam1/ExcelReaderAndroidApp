package com.mehboob.excelreaderandroidapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Inside your Room database class (e.g., AppDatabase.java)
@Database(entities = {DataModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ExcelDataDao excelDataDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
