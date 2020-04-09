package com.mmnuradityo.projectmobprog1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JadwalAdapter adapter;
    private ArrayList<JadwalKuliah> jadwalKuliahArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout);

        adapter = new JadwalAdapter(jadwalKuliahArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


    }

    void addData(){
        jadwalKuliahArrayList = new ArrayList<>();
        jadwalKuliahArrayList.add(new JadwalKuliah("Mobile Programming", "15.30 - 17-10"));
        jadwalKuliahArrayList.add(new JadwalKuliah("Jarkom", "15.30 - 17-10"));
        jadwalKuliahArrayList.add(new JadwalKuliah("Web Programming", "15.30 - 17-10"));
        jadwalKuliahArrayList.add(new JadwalKuliah("Mobile Programming", "15.30 - 17-10"));
        jadwalKuliahArrayList.add(new JadwalKuliah("Mobile Programming", "15.30 - 17-10"));
    }
}
