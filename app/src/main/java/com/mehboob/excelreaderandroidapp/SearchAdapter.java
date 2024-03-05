package com.mehboob.excelreaderandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {

    private ArrayList<ExcelDataModel> dataSet;
    private ArrayList<ExcelDataModel> filteredData;
    private Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtWord;
        TextView txtMeaning;
    }

    public SearchAdapter(ArrayList<ExcelDataModel> data, Context context) {
        this.dataSet = data;
        this.filteredData = new ArrayList<>(data);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return filteredData.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.sample_list, parent, false);
            viewHolder.txtWord = convertView.findViewById(R.id.txtWordL);
            viewHolder.txtMeaning = convertView.findViewById(R.id.txtMeaningL);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ExcelDataModel dataModel = filteredData.get(position);
        viewHolder.txtWord.setText(dataModel.getWip());
        viewHolder.txtMeaning.setText(dataModel.getMeaning());

        return convertView;
    }

    public void filter(String query) {
        query = query.toLowerCase();

        filteredData.clear();

        if (query.isEmpty()) {
            filteredData.addAll(dataSet);
        } else {
            for (ExcelDataModel data : dataSet) {
                String word = data.getWip();
                String meaning = data.getMeaning();

                if ((word != null && word.toLowerCase().contains(query)) ||
                        (meaning != null && meaning.toLowerCase().contains(query))) {
                    filteredData.add(data);
                }
            }
        }

        notifyDataSetChanged();
    }
}
