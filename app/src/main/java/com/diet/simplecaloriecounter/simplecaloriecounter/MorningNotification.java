package com.diet.simplecaloriecounter.simplecaloriecounter;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MorningNotification extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("BKalo chúc bạn buổi sáng tốt lành")
                .setContentText("Sáng nay bạn đã ăn gì? Hày điền vào ứng dụng nhé!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(100, builder.build());
    }
}
