package com.myapp.admin2d.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.admin2d.R;
import com.myapp.admin2d.models.D2;

import java.util.ArrayList;

public class D2Adapter extends RecyclerView.Adapter<D2Adapter.D2Holder> {

    ArrayList<D2> d2s = new ArrayList<D2>();

    @NonNull
    @Override
    public D2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.d2_num_item, parent, false);

        return new D2Holder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull D2Holder holder, int position) {
        holder.tvDate.setText(d2s.get(position).getDate()+"");
        holder.tvMorningNum.setText(d2s.get(position).getMorningNum());
        holder.tvEveningNum.setText(d2s.get(position).getEveningNum());

    }

    @Override
    public int getItemCount() {
        return d2s.size();
    }

    public class D2Holder extends RecyclerView.ViewHolder{

        TextView tvDate, tvMorningNum, tvEveningNum;
        public D2Holder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvMorningNum = itemView.findViewById(R.id.tv_morning);
            tvEveningNum = itemView.findViewById(R.id.tv_evening);
        }
    }
}
