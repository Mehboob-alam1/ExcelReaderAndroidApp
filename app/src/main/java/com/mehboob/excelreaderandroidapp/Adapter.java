package com.mehboob.excelreaderandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder>{
    private Context context;
    private List<ExcelDataModel> list;

    public Adapter(Context context, List<ExcelDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

     ExcelDataModel data=   list.get(position);
     holder.txtWordType.setText(data.getCategory());
     holder.txtCount.setText(" "+data.getDisplayCount()  );
     holder.txtWord.setText(data.getWip());
     holder.txtWordMeaning.setText(data.getMeaning());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView txtWordType,txtCount,txtWord,txtWordMeaning;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txtWordType=itemView.findViewById(R.id.txtWordType);
            txtCount=itemView.findViewById(R.id.txtCount);
            txtWord=itemView.findViewById(R.id.txtWord);
            txtWordMeaning=itemView.findViewById(R.id.txtWordMeaning);


        }
    }
}
