package com.example.neilm.googlecalendarapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        String extra_string = intent.getExtras().getString("extra");
        Log.e("What is the key?", extra_string);
        //Create intent to ringtone
        Intent service_intent = new Intent(context, Ringtone_Playing_Services.class);

        service_intent.putExtra("extra", extra_string);

        context.startService(service_intent);





    }
}
