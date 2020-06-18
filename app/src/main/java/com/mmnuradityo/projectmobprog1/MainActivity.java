package com.mmnuradityo.projectmobprog1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private TextView tvNama, tvNim;
    private EditText etPassword, etUsername;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNama = findViewById(R.id.tv_nama);
        tvNim = findViewById(R.id.tv_nim);
        etPassword = findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_username);
        btnLogin = findViewById(R.id.btn_login);

        Boolean login = SessionUtil.init(getApplicationContext()).getBoolean("login");
        if (login){
            pindahActivity();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();

                if (password.equals("12345678")) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    SessionUtil.init(getApplicationContext())
                            .set("login", true).set("username", etUsername.getText().toString())
                            .set("nim", Integer.valueOf(tvNim.getText().toString()));
                    pindahActivity();
                } else {
                    Toast.makeText(MainActivity.this, "Masukan Password yang Tepat", Toast.LENGTH_SHORT).show();
                }
            }

        });

        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SessionUtil.init(getApplicationContext()).set("username", etUsername.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void pindahActivity() {
        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
        startActivity(intent);

        finish();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        SessionUtil session = SessionUtil.init(getApplicationContext());
        tvNama.setText(session.getString("username"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        SessionUtil.init(getApplicationContext()).registerPreference(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SessionUtil.init(getApplicationContext()).unregisterPreference(this);
    }
}
