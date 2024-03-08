package com.mehboob.excelreaderandroidapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "excel_data")

public class DataModel {

    @PrimaryKey(autoGenerate = true)
    private int sr;
    private String category;
    private String wip;
    private String meaning;
    private String sampleSentence;

    private String customTag;

    private int readCount;
    private int displayCount;


    public DataModel(int sr, String category, String wip, String meaning, String sampleSentence, String customTag, int readCount, int displayCount) {
        this.sr = sr;
        this.category = category;
        this.wip = wip;
        this.meaning = meaning;
        this.sampleSentence = sampleSentence;
        this.customTag = customTag;
        this.readCount = readCount;
        this.displayCount = displayCount;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWip() {
        return wip;
    }

    public void setWip(String wip) {
        this.wip = wip;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSampleSentence() {
        return sampleSentence;
    }

    public void setSampleSentence(String sampleSentence) {
        this.sampleSentence = sampleSentence;
    }

    public String getCustomTag() {
        return customTag;
    }

    public void setCustomTag(String customTag) {
        this.customTag = customTag;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getDisplayCount() {
        return displayCount;
    }

    public void setDisplayCount(int displayCount) {
        this.displayCount = displayCount;
    }
}
