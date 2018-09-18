package com.example.neilm.googlecalendarapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MONDAY = 1;
    private static final int REQUEST_CODE_TUESDAY = 2;
    private static final int REQUEST_CODE_WEDNESDAY = 3;
    private static final int REQUEST_CODE_THURSDAY = 4;
    private static final int REQUEST_CODE_FRIDAY = 5;
    private static final int REQUEST_CODE_SATURDAY = 6;
    private static final int REQUEST_CODE_SUNDAY = 7;
    //Initialize text views
    TextView monday_text_view;
    TextView tuesday_text_view;
    TextView wednesday_text_view;
    TextView thursday_text_view;
    TextView friday_text_view;
    TextView saturday_text_view;
    TextView sunday_text_view;

    //Initialize switch views
    Switch monday_switch_view;
    Switch tuesday_switch_view;
    Switch wednesday_switch_view;
    Switch thursday_switch_view;
    Switch friday_switch_view;
    Switch saturday_switch_view;
    Switch sunday_switch_view;

    AlarmManager alarm_manager;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;
    String string;

    public void setAlarm(int hour, int minute, Calendar calendar, Switch switch_view){


        String hourString = String.valueOf(hour);
        String minuteString = String.valueOf(minute);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        String time = "AM";
        //Create pending intent that delays intent till calendar time
/*        pending_intent = PendingIntent.getBroadcast(MainActivity.this,
            0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);*/
        if(hour > 12){
            time = "PM";
            hourString = String.valueOf(hour -12);
        }

        if(minute < 10){
            minuteString = "0"+minuteString;
        }
        switch_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
        if(switch_view.isChecked()){
            Toast.makeText(getApplicationContext(), getString(R.string.update_alarm),
                    Toast.LENGTH_SHORT).show();
        }
        else{
            switch_view.setChecked(true);
        }


        }


    /*
    On returning from the popup it assigns the returned time, if there is one to the text view and
    sets/update an alarm for that time, turning the switch on
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        monday_text_view =(TextView) findViewById(R.id.mondayTextView);
        tuesday_text_view =(TextView) findViewById(R.id.tuesdayTextView);
        wednesday_text_view =(TextView) findViewById(R.id.wednesdayTextView);
        thursday_text_view =(TextView) findViewById(R.id.thursdayTextView);
        friday_text_view =(TextView) findViewById(R.id.fridayTextView);
        saturday_text_view =(TextView) findViewById(R.id.saturdayTextView);
        sunday_text_view =(TextView) findViewById(R.id.sundayTextView);

        monday_switch_view = (Switch) findViewById(R.id.mondaySwitch);
        tuesday_switch_view = (Switch) findViewById(R.id.tuesdaySwitch);
        wednesday_switch_view = (Switch) findViewById(R.id.wednesdaySwitch);
        thursday_switch_view = (Switch) findViewById(R.id.thursdaySwitch);
        friday_switch_view = (Switch) findViewById(R.id.fridaySwitch);
        saturday_switch_view = (Switch) findViewById(R.id.saturdaySwitch);
        sunday_switch_view = (Switch) findViewById(R.id.sundaySwitch);

        final Calendar calendar = Calendar.getInstance();


        /*Grabs hour and updates the textview, would've preferred to put all the code within another
        *method but it seems that using @Override leads to some issues with instantiating new
        * methods - should ask someone about this
        *
        *
        * Switch case itself updates the respective switch and textview depending on the
        * REQUEST_CODE which is associated with each day. Activity returns the alarm time. Turns
        * the switch button on, updating or sending out a new alarm.
        */

        Log.i("code", String.valueOf(requestCode));
        switch (requestCode) {
            case REQUEST_CODE_MONDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, monday_switch_view);

                }
                break;
            case REQUEST_CODE_TUESDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, tuesday_switch_view);

                }
                break;
            case REQUEST_CODE_WEDNESDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, wednesday_switch_view);

                }
                break;
            case REQUEST_CODE_THURSDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, thursday_switch_view);

                }
                break;
            case REQUEST_CODE_FRIDAY:
                if(resultCode == Activity.RESULT_OK) {
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, friday_switch_view);
                }
                    break;
            case REQUEST_CODE_SATURDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, saturday_switch_view);
                }
                break;
            case REQUEST_CODE_SUNDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    setAlarm(hour, minute, calendar, sunday_switch_view);
                }
                break;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initialize alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);


        //Create an instance of a calendar
        final Calendar calendar = Calendar.getInstance();


        //Initialize buttons
        Button monday_button = findViewById(R.id.mondayButton);
        Button tuesday_button = findViewById(R.id.tuesdayButton);
        Button wednesday_button = findViewById(R.id.wednesdayButton);
        Button thursday_button = findViewById(R.id.thursdayButton);
        Button friday_button = findViewById(R.id.fridayButton);
        Button saturday_button = findViewById(R.id.saturdayButton);
        Button sunday_button = findViewById(R.id.sundayButton);

        //Initialze Switches
        monday_switch_view = (Switch) findViewById(R.id.mondaySwitch);
        tuesday_switch_view = (Switch) findViewById(R.id.tuesdaySwitch);
        wednesday_switch_view = (Switch) findViewById(R.id.wednesdaySwitch);
        thursday_switch_view = (Switch) findViewById(R.id.thursdaySwitch);
        friday_switch_view = (Switch) findViewById(R.id.fridaySwitch);
        saturday_switch_view = (Switch) findViewById(R.id.saturdaySwitch);
        sunday_switch_view = (Switch) findViewById(R.id.sundaySwitch);




        //Bind all 7 on click listeners to the popup window to set time
        monday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Popup.makeIntent(MainActivity.this);
                startActivityForResult(intent, 1);

            }
        });



        tuesday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 2);

            }
        });

        wednesday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 3);

            }
        });

        thursday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 4);

            }
        });

        friday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 5);

            }
        });

        saturday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 6);

            }
        });

        sunday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 7);

            }
        });

    }


}
