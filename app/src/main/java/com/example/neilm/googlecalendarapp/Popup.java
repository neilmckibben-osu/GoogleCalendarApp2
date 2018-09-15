package com.example.neilm.googlecalendarapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Popup extends Activity{
    TimePicker alarm_timepicker;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        //Initialize timepicker
        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout(width, (int)(height*.75));




        //Initialize buttons
        Button quit_out = findViewById(R.id.quitOut);
        Button select_time = findViewById(R.id.selectTime);


        quit_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        select_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm_timepicker = findViewById(R.id.timePicker);
                int hour = alarm_timepicker.getCurrentHour();
                int minute = alarm_timepicker.getCurrentMinute();
                Intent returnValue = new Intent();
                returnValue.putExtra("hour time", (hour));
                returnValue.putExtra("minute time", minute);
                setResult(RESULT_OK, returnValue);
                finish();
           }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Popup.class);
    }
}
