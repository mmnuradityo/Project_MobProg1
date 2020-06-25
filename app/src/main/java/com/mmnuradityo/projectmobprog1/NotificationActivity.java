package com.mmnuradityo.projectmobprog1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etContent;
    private Button btnShowNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        btnShowNotif = findViewById(R.id.btn_show_notif);

        btnShowNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();

                NotificationUtil notificationUtil = new NotificationUtil(NotificationActivity.this);
                notificationUtil.setTitle(title);
                notificationUtil.setContent(content);
                notificationUtil.showNotification();

                etTitle.setText("");
                etContent.setText("");
            }
        });
    }
}
