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




        Log.i("code", String.valueOf(requestCode));
        switch (requestCode) {
            case REQUEST_CODE_MONDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    monday_switch_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
                }
                break;
            case REQUEST_CODE_TUESDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    tuesday_text_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
                }
                break;
            case REQUEST_CODE_WEDNESDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    wednesday_text_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
                }
                break;
            case REQUEST_CODE_THURSDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    thursday_text_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
                }
                break;
            case REQUEST_CODE_FRIDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    friday_text_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
                }
                break;
            case REQUEST_CODE_SATURDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    saturday_text_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
                }
                break;
            case REQUEST_CODE_SUNDAY:
                if(resultCode == Activity.RESULT_OK){
                    int hour = data.getIntExtra("hour time", 0);
                    int minute = data.getIntExtra("minute time", 0);
                    String hourString = String.valueOf(hour);
                    String minuteString = String.valueOf(minute);
                    String time = "AM";
                    if(hour > 12){
                        time = "PM";
                        hourString = String.valueOf(hour -12);
                    }

                    if(minute < 10){
                        minuteString = "0"+minuteString;
                    }
                    sunday_text_view.setText("Alarm set for: "+hourString+":"+minuteString+" "+time);
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
