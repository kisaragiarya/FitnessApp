package com.example.fitnessapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    ImageButton goback;
    TextView textAlarmPrompt;
    TimePickerDialog timePickerDialog;

    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        textAlarmPrompt = (TextView) findViewById(R.id.textView33);
        goback = findViewById(R.id.gobackb);
        buttonstartSetDialog = (Button) findViewById(R.id.startSetDialog);
        buttonstartSetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAlarmPrompt.setText("");
                openTimePickerDialog(false);
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gobackku();
            }
        });

    }

    private void gobackku(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    private void openTimePickerDialog(boolean is24r) {
        Calendar calendar = Calendar.getInstance();

        timePickerDialog = new TimePickerDialog(Alarm.this,
                onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), is24r);
        timePickerDialog.setTitle("Set Alarm Time");

        timePickerDialog.show();

    }

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if (calSet.compareTo(calNow) <= 0) {
                // Today Set time passed, count to tomorrow
                calSet.add(Calendar.DATE, 1);
            }

            setAlarm(calSet);
        }
    };



    private void setAlarm(Calendar targetCal) {

        textAlarmPrompt.setText("\n\n***\n" + "Alarm is set "
                + targetCal.getTime() + "\n" + "***\n");

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
                pendingIntent);

    }
}




