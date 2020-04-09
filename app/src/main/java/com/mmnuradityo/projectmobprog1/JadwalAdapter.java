package com.mmnuradityo.projectmobprog1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    private ArrayList<JadwalKuliah> dataList;

    public class JadwalViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMatkul, txtJam;

        public JadwalViewHolder(View itemView) {
            super(itemView);
            txtMatkul = (TextView) itemView.findViewById(R.id.mata_kuliah);
            txtJam = (TextView) itemView.findViewById(R.id.jam_kuliah);
        }
    }

    public JadwalAdapter(ArrayList<JadwalKuliah> dataList) {
        this.dataList = dataList;
    }

    @Override
    public JadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JadwalViewHolder holder, int position) {
        holder.txtMatkul.setText(dataList.get(position).getMataKuliah());
        holder.txtJam.setText(dataList.get(position).getJamKuliah());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }
}
