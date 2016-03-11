package com.bedoya.esau.datos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private TextView tDateDisplay;
    private Button bPickDate;
    private int yea;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 0;

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    yea = year;
                    month = monthOfYear;
                    day = dayOfMonth;
                    updateDisplay();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        bPickDate = (Button) findViewById(R.id.pickDate);
        // add a click listener to the button
        bPickDate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        //Para obtener la fecha actual del sistema
        final Calendar c = Calendar.getInstance();
        yea = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        // display the current date (this method is below)
        updateDisplay();
    }

    private void updateDisplay() {
        tDateDisplay.setText(
                new StringBuilder()
                        .append(day).append("/")
                        .append(month + 1).append("/")
                        .append(yea).append(" "));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        yea, month, day);
        }
        return null;
    }

}
