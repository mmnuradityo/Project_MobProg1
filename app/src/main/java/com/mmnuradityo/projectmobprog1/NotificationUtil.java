package com.mmnuradityo.projectmobprog1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import java.util.Date;

public class NotificationUtil {

    public static String NOTIFICATION_KEY = "notifKey";
    private Context context;
    private NotificationManager notificationManager;
    private String title;
    private String content;
    private String notificationName;
    private String notificationChannelId;
    private PendingIntent contentIntent;

    public NotificationUtil(Context context) {
        this.context = context;
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void showNotification() {
        setChannel();
        setIntentContent();
        setNotif();
    }

    private void setChannel() {
        notificationChannelId = context.getPackageName();
        notificationName = context.getApplicationInfo().name;
    }

    private void setIntentContent() {
        Intent newIntent = new Intent(context, FirstActivity.class);
        newIntent.putExtra(NOTIFICATION_KEY, content);
        contentIntent = PendingIntent.getActivity(context, 0,
                newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void setNotif() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notifChannel = new NotificationChannel(
                    notificationChannelId, notificationName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notifChannel);
        }

        NotificationCompat.Builder notifBuilder =
                new NotificationCompat.Builder(context, notificationChannelId)
                        .setContentTitle(title)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setContentText(content)
                        .setAutoCancel(true)
                        .setContentIntent(contentIntent);

        int notificationId = (int) new Date().getTime();
        notificationManager.notify(notificationId, notifBuilder.build());
    }
}
