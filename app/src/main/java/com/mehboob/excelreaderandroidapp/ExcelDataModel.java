package com.mehboob.excelreaderandroidapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ExcelDataModel implements Parcelable {

    private int sr;
    private String category;
    private String wip;
    private String meaning;
    private String sampleSentence;

    private String customTag;

    private int readCount;
    private int displayCount;


    public ExcelDataModel(int sr, String category, String wip, String meaning, String sampleSentence, String customTag, int readCount, int displayCount) {
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



    protected ExcelDataModel(Parcel in) {
        sr = in.readInt();
        category = in.readString();
        wip = in.readString();
        meaning = in.readString();
        sampleSentence = in.readString();
        customTag = in.readString();
        readCount = in.readInt();
        displayCount = in.readInt();
    }

    public static final Creator<ExcelDataModel> CREATOR = new Creator<ExcelDataModel>() {
        @Override
        public ExcelDataModel createFromParcel(Parcel in) {
            return new ExcelDataModel(in);
        }

        @Override
        public ExcelDataModel[] newArray(int size) {
            return new ExcelDataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sr);
        dest.writeString(category);
        dest.writeString(wip);
        dest.writeString(meaning);
        dest.writeString(sampleSentence);
        dest.writeString(customTag);
        dest.writeInt(readCount);
        dest.writeInt(displayCount);
    }

}
