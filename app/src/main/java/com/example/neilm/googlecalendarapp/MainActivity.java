package com.example.neilm.googlecalendarapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // to make our alarm manager
    AlarmManager alarm_manager;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initialize alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);


        //Initialize our text update box
        update_text = (TextView) findViewById(R.id.update_text);

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


        //Bind all 7 on click listeners to the popup window to set time
        monday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Popup.class), 1);
                onActivityResult();

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        int[] arrayRequestCodes = {1, 2, 3, 4, 5, 6, 7};
        String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        super.onActivityResult(requestCode, resultCode, data);
        for(int i = 1; i <= arrayRequestCodes.length; i++){
            if(requestCode == arrayRequestCodes[i] && resultCode == RESULT_OK){
             data.getStringExtra("alarm times");
            }
        }
    }
}
