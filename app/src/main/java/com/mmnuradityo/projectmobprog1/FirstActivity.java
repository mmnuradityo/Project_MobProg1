package com.mmnuradityo.projectmobprog1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private TextView tvUser;
    private Button btnActivity;
    private Button btnActivityFragment;
    private Button btnRecylerView;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        SessionUtil preferences = SessionUtil.init(getApplicationContext());

        String nama = preferences.getString("username");
        Integer nim = preferences.getInt("nim");

        Toast.makeText(getApplicationContext(), "NIM Integer: "+nim,Toast.LENGTH_SHORT).show();

        tvUser = findViewById(R.id.tv_user);
        btnActivity = findViewById(R.id.btn_pindah_activity);
        btnActivityFragment = findViewById(R.id.btn_pindah_activity_fragment);
        btnRecylerView = findViewById(R.id.btn_pindah_recyclerview);
        btnLogout = findViewById(R.id.btn_logout);

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

        btnRecylerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this, RecyclerViewActivity.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionUtil.init(getApplicationContext()).set("login", false);

                startActivity(new Intent(FirstActivity.this, MainActivity.class));
                finish();
            }
        });

    }

}
