package com.mehboob.excelreaderandroidapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

@Database(entities = {DataModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "app_database";

    public abstract ExcelDataDao excelDataDao();

    private static volatile AppDatabase instance = null;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }

        return instance;
    }

    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            Log.d("AppDatabase", "Created");
            // You may insert initial data here if needed.
        }
    };

    public void insertData(List<DataModel> dataModels) {
        new InsertDataAsyncTask(instance, dataModels).execute();
    }

    static class InsertDataAsyncTask extends AsyncTask<Void, Void, Void> {
        private ExcelDataDao excelDataDao;
        private List<DataModel> dataModels;

        public InsertDataAsyncTask(AppDatabase database, List<DataModel> dataModels) {
            excelDataDao = database.excelDataDao();
            this.dataModels = dataModels;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            excelDataDao.insert(dataModels);
            return null;
        }
    }
}
