package com.example.myapplication;

import static androidx.legacy.content.WakefulBroadcastReceiver.startWakefulService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import
        android.content.ComponentName;
import
        android.content.Context;
import
        android.content.Intent;
import
        android.media.Ringtone;
import
        android.media.RingtoneManager;
import
        android.net.Uri;

import androidx.legacy.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlarmActivity inst = AlarmActivity.instance();
        inst.setAlarmText("Alarm! Wake up! Wake up!");
        Uri alarmUri =
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM
                );
        if (alarmUri == null) {
            alarmUri =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        ComponentName comp = new ComponentName(context.getPackageName(), AlarmService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}