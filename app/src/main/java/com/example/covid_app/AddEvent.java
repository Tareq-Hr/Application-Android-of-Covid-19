package com.example.covid_app;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class AddEvent extends AppCompatActivity implements DatePickerDialog.OnDateSetListener , TimePickerDialog.OnTimeSetListener{

    EditText title,description,date,hour;
    Button add_event;
    Calendar calendar ;
    DatePickerDialog datePickerDialog ;
    TimePickerDialog timePickerDialog ;
    int CalendarHour, CalendarMinute;
    int Year, Month, Day ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        title = findViewById(R.id.title);
        description= findViewById(R.id.description);
        date= findViewById(R.id.date);
        hour= findViewById(R.id.hour);
        add_event= findViewById(R.id.add_event);

        calendar = Calendar.getInstance();

        Year = calendar.get(Calendar.YEAR) ;
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setInputType(InputType.TYPE_NULL);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                datePickerDialog = DatePickerDialog.newInstance(AddEvent.this, Year, Month, Day);

                datePickerDialog.setThemeDark(false);

                datePickerDialog.showYearPickerFirst(false);

                datePickerDialog.setAccentColor(Color.parseColor("#FF8A65"));

                datePickerDialog.setTitle("Select Date From DatePickerDialog");

                datePickerDialog.show(getFragmentManager(), "DatePickerDialog");

            }
        });

        hour.setInputType(InputType.TYPE_NULL);
        hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CalendarHour = calendar.get(Calendar.HOUR_OF_DAY);

                CalendarMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = TimePickerDialog.newInstance(AddEvent.this, CalendarHour, CalendarMinute, true);

                timePickerDialog.setAccentColor(Color.parseColor("#FF8A65"));

                timePickerDialog.setThemeDark(false);

                timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                    @Override
                    public void onCancel(DialogInterface dialogInterface) {

                        Toast.makeText(AddEvent.this, "Time Not Selected", Toast.LENGTH_SHORT).show();
                    }
                });

                timePickerDialog.show(getFragmentManager(), "Material Design TimePicker Dialog");

            }
        });

    }


    @Override
    public void onDateSet(DatePickerDialog view, int Year, int Month, int Day) {

        String d =  Day + "/" + Month + "/" + Year;

        date.setText(d);
        //Toast.makeText(AddEvent.this, d, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

        int Hour = 0 ;

        if(hourOfDay > 12)
        {
            switch (hourOfDay)
            {
                case 13 :
                    Hour = 1 ;
                    break;

                case 14 :
                    Hour = 2 ;
                    break;

                case 15 :
                    Hour = 3 ;
                    break;

                case 16 :
                    Hour = 4 ;
                    break;

                case 17 :
                    Hour = 5 ;
                    break;

                case 18 :
                    Hour = 6 ;
                    break;

                case 19 :
                    Hour =  7;
                    break;

                case 20 :
                    Hour = 8 ;
                    break;

                case 21 :
                    Hour = 9 ;
                    break;

                case 22 :
                    Hour = 10 ;
                    break;

                case 23 :
                    Hour = 11 ;
                    break;

                case 24 :
                    Hour = 12 ;
                    break;
            }

        }
        else {

            Hour = hourOfDay ;
        }

        String SelectedTime = Hour + " : " + minute ;

        hour.setText(SelectedTime);
        Toast.makeText(AddEvent.this, SelectedTime, Toast.LENGTH_LONG).show();
    }


}
