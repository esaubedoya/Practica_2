package com.bedoya.esau.calculos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int op=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eN1 = (EditText) findViewById(R.id.eNro1);
        final EditText eN2 = (EditText) findViewById(R.id.eNro2);
        final TextView tRes = (TextView) findViewById(R.id.tResultado);
        Button bCal = (Button) findViewById(R.id.bCalcular);

        bCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double nro1, nro2, res;

                if(eN1.getText().toString().trim().length()>0 && eN2.getText().toString().trim().length()>0) {

                    nro1 = Double.parseDouble(eN1.getText().toString());
                    nro2 = Double.parseDouble(eN2.getText().toString());

                    switch (op) {

                        case 1:
                            res = nro1 + nro2;
                            tRes.setText(String.valueOf(res));
                            break;
                        case 2:
                            res = nro1 - nro2;
                            tRes.setText(String.valueOf(res));
                            break;
                        case 3:
                            res = nro1 * nro2;
                            tRes.setText(String.valueOf(res));
                            break;
                        case 4:
                            if (nro2 != 0) {
                                res = nro1 / nro2;
                                tRes.setText(String.valueOf(res));
                            } else
                                tRes.setText("División por cero");
                            break;
                        default:
                            tRes.setText("Seleccione una operación.");
                            break;

                    }

                }else
                    tRes.setText("Faltan datos");

            }
        });
    }

        public void onRadioButtonClicked(View view){

            boolean check= ((RadioButton) view).isChecked();

            switch(view.getId()) {
                case R.id.rSuma:
                    if (check)
                       op=1;
                       break;
                case R.id.rResta:
                    if (check)
                        op=2;
                        break;
                case R.id.rMulti:
                    if(check)
                        op=3;
                    break;
                case R.id.rDivision:
                    if(check)
                        op=4;
                    break;
            }

        }


}


