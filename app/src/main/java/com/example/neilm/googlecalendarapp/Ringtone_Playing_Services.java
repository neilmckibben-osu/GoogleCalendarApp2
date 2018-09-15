package com.example.neilm.googlecalendarapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;



public class Ringtone_Playing_Services extends Service {

    boolean isRunning;
    int startId;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("LocalService", "Recieved start id " + startId + ":" + intent);

        String state = intent.getExtras().getString("extras");




        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        assert state != null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }


        //n music, alarm on

        if (!this.isRunning && startId == 1) {
            r.play();
            this.isRunning = true;
            this.startId = 0;

            NotificationManager notify_manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            //set up intent
            Intent intent_main_activity = new Intent(this.getApplicationContext(), MainActivity.class);
            PendingIntent pending_intent_main = PendingIntent.getActivity(this, 0,
                    intent_main_activity, 0);

            Notification notification_popup = new Notification.Builder(this)
                    .setContentTitle("An alarm is going off")
                    .setContentText("Click me!")
                    .setContentIntent(pending_intent_main)
                    .setAutoCancel(true)
                    .build();

            notify_manager.notify(0, notification_popup);
        }

        //music, alarm off
        else if (this.isRunning && startId == 0) {
            r.stop();
            this.isRunning = false;
            this.startId = 0;
        }
        //rand buttons
        else if(!this.isRunning && startId == 0){
            this.isRunning = false;
            this.startId = 0;
        }

        else if(this.isRunning && startId == 1){
            this.isRunning = true;
            this.startId = 1;
        }

        else{
            Log.e("How?", "Shouldnt be possible");
        }








        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        Log.e("On destroy called", "ded");
        super.onDestroy();
        this.isRunning = false;
    }

    public int onStartCommand(Intent intent){

        Log.e("in the service", "startcommand");

        return START_NOT_STICKY;
    }
}
