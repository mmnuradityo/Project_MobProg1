package com.mmnuradityo.projectmobprog1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private TextView tvUser;
    private Button btnActivity;
    private Button btnActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        String nama = getIntent().getStringExtra("nama");

        tvUser = findViewById(R.id.tv_user);
        btnActivity = findViewById(R.id.btn_pindah_activity);
        btnActivityFragment = findViewById(R.id.btn_pindah_activity_fragment);

        tvUser.setText(nama);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });

        btnActivityFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, FragmentActivity.class));
            }
        });

    }

}
