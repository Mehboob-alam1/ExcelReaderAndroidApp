package com.mehboob.excelreaderandroidapp;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ExcelRepo {

    private ExcelDataDao excelDataDao;
    private LiveData<List<DataModel>> allExcelData;
    private AppDatabase database;

    public ExcelRepo(Application application) {
        database = AppDatabase.getInstance(application);
        excelDataDao = database.excelDataDao();
        allExcelData = excelDataDao.getAll(); // Assuming you have a getAll() method in your DAO
    }

    // Method to get LiveData for all ExcelData
    public LiveData<List<DataModel>> getAllExcelData() {
        return allExcelData;
    }

    // Method to update the view count
    public void updateDisplayCounts(int itemId,int newCount) {

      new UpdateDisplayCountAsyncTask(itemId,database,newCount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    public void updateReadCount(int itemId, int readCount) {


       new  UpdateReadCountAsyncTask(database,itemId,readCount).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);



    }


    public LiveData<DataModel> getDataModel(int itemId) {
        return excelDataDao.getById(itemId);

    }

    public void insertData(List<DataModel> dataModels) {
        new InsertAsyncTask(database).execute(dataModels);
    }


    static class InsertAsyncTask extends AsyncTask<List<DataModel>, Void, Void> {
        private ExcelDataDao excelDataDao;

        InsertAsyncTask(AppDatabase dataDatabase) {
            excelDataDao = dataDatabase.excelDataDao();
        }


        @Override
        protected Void doInBackground(List<DataModel>... lists) {
            excelDataDao.insert(lists[0]);
            return null;
        }
    }

    static class UpdateReadCountAsyncTask extends AsyncTask<Void, Void, Void> {
        private ExcelDataDao excelDataDao;
        private int itemId;
        private int readCount;

        public UpdateReadCountAsyncTask(AppDatabase database,int itemId, int readCount) {

            excelDataDao = database.excelDataDao();
            this.itemId = itemId;
            this.readCount = readCount;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            excelDataDao.updateReadCount(itemId, readCount);
            return null;
        }
    }



    static class UpdateDisplayCountAsyncTask extends AsyncTask<Void,Void,Void>{


        private ExcelDataDao excelDataDao;
        private int itemId;
        private int displayCount;

        public UpdateDisplayCountAsyncTask(int itemId,AppDatabase database,int displayCount) {
            excelDataDao = database.excelDataDao();
            this.itemId = itemId;
            this.displayCount=displayCount;

        }
        @Override
        protected Void doInBackground(Void... voids) {
            excelDataDao.updateDisplayCount(itemId,displayCount);
            return null;
        }
    }
}
