package com.diet.simplecaloriecounter.simplecaloriecounter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import android.app.Activity;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.diet.simplecaloriecounter.simplecaloriecounter.MainActivity;
import com.diet.simplecaloriecounter.simplecaloriecounter.R;

import java.util.Calendar;

public class AfternoonNotification extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("BKalo chúc bạn buổi tối tốt lành")
                .setContentText("Tối nay bạn đã ăn gì? Hày điền vào ứng dụng nhé!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build());
    }


}
