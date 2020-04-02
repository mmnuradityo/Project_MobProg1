package com.mmnuradityo.projectmobprog1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvNama;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNama = findViewById(R.id.tv_nama);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();

                if (password.equals("12345678")) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                    intent.putExtra("nama", tvNama.getText().toString());
                    startActivity(intent);

                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Masukan Password yang Tepat", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}
