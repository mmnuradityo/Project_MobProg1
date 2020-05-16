package com.mmnuradityo.projectmobprog1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {

    private TextView tvTextOption;
    private Button btnFragmentBrowser;
    private Button btnFragmentFileManager;
    private Button btnFragmentCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        tvTextOption = findViewById(R.id.tv_text_option);
        btnFragmentBrowser = findViewById(R.id.btn_fragment_Browser);
        btnFragmentFileManager = findViewById(R.id.btn_fragment_file_manager);
        btnFragmentCamera = findViewById(R.id.btn_fragment_camera);

        btnFragmentBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahFragment(new FragmentBrowser());
            }
        });

        btnFragmentFileManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahFragment(new FragmentFile());
            }
        });

        btnFragmentCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahFragment(new FragmentCamera());
            }
        });
    }

    private void ubahFragment(Fragment fragment) {
        tvTextOption.setVisibility(View.GONE);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmnet_container, fragment);
        transaction.commit();
    }

}
