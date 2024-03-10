package com.mehboob.excelreaderandroidapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> filteredData;
    private Context mContext;

    // View lookup cache
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtWord;
        TextView txtMeaning;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtWord = itemView.findViewById(R.id.txtWordL);
        txtMeaning = itemView.findViewById(R.id.txtMeaningL);
        }
    }

    public SearchAdapter(ArrayList<DataModel> data, Context context) {
        this.dataSet = data;
        this.filteredData = new ArrayList<>(data);
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.sample_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       DataModel dataModel = filteredData.get(position);
        holder.txtWord.setText(dataModel.getWip());
        holder.txtMeaning.setText(dataModel.getMeaning());

        holder.itemView.setOnClickListener(v -> {


            Gson gson= new Gson();

            Intent i = new Intent(mContext, WordDetailActivity.class);
            i.putExtra("data",gson.toJson(dataModel));
           mContext.startActivity(i);
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return filteredData.size();
    }


    public void filter(String query) {
        query = query.toLowerCase();

        filteredData.clear();

        if (query.isEmpty()) {
            filteredData.addAll(dataSet);
        } else {
            for (DataModel data : dataSet) {
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
