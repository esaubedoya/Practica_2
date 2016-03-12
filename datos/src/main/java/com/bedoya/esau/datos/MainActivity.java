package com.bedoya.esau.datos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView tDateDisplay;
    private Button bPickDate;
    private int yea;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 0;
    int op=0;
    TextView ciuNac;

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
        final EditText eName = (EditText) findViewById(R.id.eName);
        final EditText ePw = (EditText) findViewById(R.id.ePw);
        final EditText eRpw = (EditText) findViewById(R.id.eRpw);
        final EditText eEmail = (EditText) findViewById(R.id.eEmail);
        final Spinner sCiudad = (Spinner) findViewById(R.id.sCiudad);
        final Button bEnviar = (Button) findViewById(R.id.bEnviar);
        final TextView tRes = (TextView) findViewById(R.id.tResultado);
        final CheckBox cCine = (CheckBox) findViewById(R.id.cCine);
        final CheckBox cTv = (CheckBox) findViewById(R.id.cTv);
        final CheckBox cFutbol = (CheckBox) findViewById(R.id.cFutbol);
        final CheckBox cLeer = (CheckBox) findViewById(R.id.cLeer);
        Button bLimpiar = (Button) findViewById(R.id.bLimpiar);


        bPickDate.setOnClickListener(new View.OnClickListener() {
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

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.ciudades, R.layout.support_simple_spinner_dropdown_item);
        sCiudad.setAdapter(adapter);
        sCiudad.setOnItemSelectedListener(this);

        bEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String pw, rpw, sex, mcine="", mfut="", mtv="", mleer="", fecha;

                pw = ePw.getText().toString();
                rpw = eRpw.getText().toString();
                fecha=tDateDisplay.getText().toString();

                if(cCine.isChecked())
                    mcine="Cine";
                if(cFutbol.isChecked())
                    mfut="Soccer";
                if(cLeer.isChecked())
                    mleer="Reading";
                if(cTv.isChecked())
                    mtv="TV";

                if (op == 1)
                    sex = "female";
                else
                    sex = "male";

                if (eName.getText().toString().trim().length() <= 0 || ePw.getText().toString().trim().length() <= 0
                        || eRpw.getText().toString().trim().length() <= 0 || eEmail.getText().toString().trim().length() <= 0)
                   tRes.setText("Faltan datos");
                else if (pw.equals(rpw) == false)
                    tRes.setText("No coincide la contraseña");
                else if (op == 0)
                    tRes.setText("Seleccione un sexo");
                else if (!(cCine.isChecked() || cFutbol.isChecked() || cLeer.isChecked() || cTv.isChecked()))
                   tRes.setText("Seleccione al menos un hobby");
                else {
                    tRes.setText(eName.getText().toString() + " " + pw + " " + eEmail.getText().toString()
                            + " " + sex + " "+ ciuNac.getText()+" " + fecha + " "  + " "
                            + mfut + " " + mcine + " " + mleer + " "+ mtv );
                }

            }


        });

        bLimpiar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                eName.setText("");
                ePw.setText("");
                eRpw.setText("");
                eEmail.setText("");
                cCine.setChecked(false);
                cFutbol.setChecked(false);
                cLeer.setChecked(false);
                cTv.setChecked(false);
                tRes.setText("");
            }
        });
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

    public void onRadioButtonClicked (View v) {

        boolean clik=((RadioButton) v).isChecked();

        switch (v.getId()) {

            case R.id.rFemale:
                if(clik)
                    op=1;
                break;
            case R.id.rMale:
                if(clik)
                    op=2;
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ciuNac=((TextView) view);
        //Toast.makeText(this, "Ciudad de nacimiento:  "+texto.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
