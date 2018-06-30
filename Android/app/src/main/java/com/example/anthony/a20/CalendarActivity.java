package com.example.anthony.a20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Calendar nextWeek = Calendar.getInstance();
        int i = nextWeek.get(Calendar.WEEK_OF_MONTH);
        nextWeek.set(Calendar.WEEK_OF_MONTH,++i);
        CalendarPickerView calendar = findViewById(R.id.calendar_view);
        Date today = Calendar.getInstance().getTime();
        Log.d("semana", String.valueOf(i));
        calendar.init(today,nextWeek.getTime()).withSelectedDate(today);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.8));
    }
}
