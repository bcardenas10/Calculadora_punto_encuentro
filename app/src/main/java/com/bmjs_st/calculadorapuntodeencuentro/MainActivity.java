package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_veh1; EditText tn_velo1;
    EditText et_veh2; EditText tn_velo2;
    EditText tn_distancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_veh1 = (EditText) findViewById(R.id.et_veh1);
        tn_velo1 = (EditText) findViewById(R.id.tn_velo1);
        et_veh2 = (EditText) findViewById(R.id.et_veh2);
        tn_velo2 = (EditText) findViewById(R.id.tn_velo2);
        tn_distancia = (EditText) findViewById(R.id.tn_distancia);

    }

    public void calcular(View v) {
        Intent resultado = new Intent(this, Resultado.class);
        startActivity(resultado);
    }

    public void verHistorial(View v) {
        /*Intent historial = new Intent(this, Historial.class);
        startActivity(historial);*/
    }

    public void config(View v){
        Intent config = new Intent(this, Configuracion.class);
        startActivity(config);
    }

}