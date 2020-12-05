package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
    }

    public void nuevoCalculo(View v) {
        Intent nuevoCalc = new Intent(this, MainActivity.class);
        startActivity(nuevoCalc);
    }

    public void verHistorial(View v) {
        /*Intent historial = new Intent(this, Historial.class);
        startActivity(historial);*/
    }
}