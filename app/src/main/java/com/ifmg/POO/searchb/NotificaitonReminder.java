package com.ifmg.POO.searchb;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.ifmg.POO.searchb.modelos.Versiculo;

public class NotificaitonReminder extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Informações da mensagem
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"alerta")
                .setSmallIcon(R.mipmap.new_icon_foreground)
                .setContentTitle("Já leu a biblia hoje ?")
                .setContentText("A qual a seu tempo mostrará o bem-aventurado, e único poderoso Senhor, Rei dos reis e Senhor dos senhores;\n" +
                        "\n" +
                        "1 Timóteo 6:15")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("A qual a seu tempo mostrará o bem-aventurado, e único poderoso Senhor, Rei dos reis e Senhor dos senhores; \n \n 1 Timóteo 6:15"));
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        notificationManager.notify(200, builder.build());
    }
}
