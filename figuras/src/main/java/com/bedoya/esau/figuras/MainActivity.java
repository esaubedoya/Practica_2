package com.bedoya.esau.figuras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int op=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eCirculo=(EditText) findViewById(R.id.eCirculo);
        final EditText eCuadro=(EditText) findViewById(R.id.eCuadro);
        final EditText eRecAncho=(EditText)findViewById(R.id.eRecAncho);
        final EditText eRecAlto=(EditText) findViewById(R.id.eRecAlto);
        final EditText eTriaBase=(EditText) findViewById(R.id.eTriaBase);
        final EditText eTriaAlto=(EditText) findViewById(R.id.eTriaAlto);
        final TextView tResul=(TextView) findViewById(R.id.tResultado);
        final TextView tEtRe=(TextView) findViewById(R.id.tEtiRes);
        Button bCal= (Button)findViewById(R.id.bCalcular);

        eCirculo.setVisibility(View.GONE);
        eCuadro.setVisibility(View.GONE);
        eRecAncho.setVisibility(View.GONE);
        eRecAlto.setVisibility(View.GONE);
        eTriaBase.setVisibility(View.GONE);
        eTriaAlto.setVisibility(View.GONE);

        bCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double elem1, elem2, res;

                switch (op){

                    case 1:
                        if(eCirculo.getText().toString().trim().length()>0) {
                            elem1 = Double.valueOf(eCirculo.getText().toString());
                            res = 3.141592 * elem1;
                            tEtRe.setVisibility(View.VISIBLE);
                            tResul.setText(String.valueOf(res));
                            tResul.setVisibility(View.VISIBLE);
                        }else{
                            tResul.setVisibility(View.VISIBLE);
                            tResul.setText("Faltan datos");
                        }

                        break;
                    case 2:
                        if(eCuadro.getText().toString().trim().length()>0) {
                            elem1 = Double.valueOf(eCuadro.getText().toString());
                            res = elem1 * elem1;
                            tEtRe.setVisibility(View.VISIBLE);
                            tResul.setText(String.valueOf(res));
                            tResul.setVisibility(View.VISIBLE);
                        }else{
                            tResul.setVisibility(View.VISIBLE);
                            tResul.setText("Faltan datos");
                        }
                        break;
                    case 3:
                        if(eRecAlto.getText().toString().trim().length()>0 && eRecAncho.getText().toString().length()>0) {
                            elem1 = Double.valueOf(eRecAlto.getText().toString());
                            elem2 = Double.valueOf(eRecAncho.getText().toString());
                            res = elem1 * elem2;
                            tEtRe.setVisibility(View.VISIBLE);
                            tResul.setText(String.valueOf(res));
                            tResul.setVisibility(View.VISIBLE);
                        }else{
                            tResul.setVisibility(View.VISIBLE);
                            tResul.setText("Faltan datos");
                        }
                        break;
                    case 4:
                        if(eTriaAlto.getText().toString().trim().length()>0 && eTriaBase.getText().toString().trim().length()>0) {
                            elem1 = Double.valueOf(eTriaAlto.getText().toString());
                            elem2 = Double.valueOf(eTriaBase.getText().toString());
                            res = (elem1 * elem2) / 2;
                            tEtRe.setVisibility(View.VISIBLE);
                            tResul.setText(String.valueOf(res));
                            tResul.setVisibility(View.VISIBLE);
                        }else{
                            tResul.setVisibility(View.VISIBLE);
                            tResul.setText("Faltan datos");
                        }
                        break;
                    default:
                        tEtRe.setVisibility(View.VISIBLE);
                        tResul.setText("Opción no válida");
                        tResul.setVisibility(View.VISIBLE);

                }


            }
        });
    }

   public void onRadioButtonClicked(View v){

        boolean clik=((RadioButton) v).isChecked();

        final EditText eCir=(EditText) findViewById(R.id.eCirculo);
        final EditText eCua=(EditText) findViewById(R.id.eCuadro);
        final EditText eRecAn=(EditText)findViewById(R.id.eRecAncho);
        final EditText eRecAl=(EditText) findViewById(R.id.eRecAlto);
        final EditText eTriaBa=(EditText) findViewById(R.id.eTriaBase);
        final EditText eTriaAl=(EditText) findViewById(R.id.eTriaAlto);
        final TextView tEtRe=(TextView) findViewById(R.id.tEtiRes);
        final TextView tRe=(TextView) findViewById(R.id.tResultado);
        final Button bCal=(Button)findViewById(R.id.bCalcular);

        tEtRe.setVisibility(View.GONE);
        tRe.setVisibility(View.GONE);
        bCal.setVisibility(View.VISIBLE);

        switch (v.getId()) {

            case R.id.rCirculo:
                if (clik) {
                    eCir.setVisibility(View.VISIBLE);
                    eCua.setVisibility(View.GONE);
                    eRecAn.setVisibility(View.GONE);
                    eRecAl.setVisibility(View.GONE);
                    eTriaBa.setVisibility(View.GONE);
                    eTriaAl.setVisibility(View.GONE);
                    op=1;
                }
                break;
            case R.id.rCuadro:
                if (clik) {
                    eCir.setVisibility(View.GONE);
                    eCua.setVisibility(View.VISIBLE);
                    eRecAn.setVisibility(View.GONE);
                    eRecAl.setVisibility(View.GONE);
                    eTriaBa.setVisibility(View.GONE);
                    eTriaAl.setVisibility(View.GONE);
                    op=2;
                }
                break;
            case R.id.rRectangulo:
                if (clik) {
                    eCir.setVisibility(View.GONE);
                    eCua.setVisibility(View.GONE);
                    eRecAn.setVisibility(View.VISIBLE);
                    eRecAl.setVisibility(View.VISIBLE);
                    eTriaBa.setVisibility(View.GONE);
                    eTriaAl.setVisibility(View.GONE);
                    op=3;
                }
                break;
            case R.id.rTriangulo:
                if (clik) {
                    eCir.setVisibility(View.GONE);
                    eCua.setVisibility(View.GONE);
                    eRecAn.setVisibility(View.GONE);
                    eRecAl.setVisibility(View.GONE);
                    eTriaBa.setVisibility(View.VISIBLE);
                    eTriaAl.setVisibility(View.VISIBLE);
                    op=4;
                }

        }
    }

}
