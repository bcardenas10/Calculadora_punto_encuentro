package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    ArrayList lista_sims = MainActivity.lista_sims;
    private ListView lvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        lvDatos = (ListView) findViewById(R.id.lvDatos);
        ArrayAdapter <Simulacion> simul = new ArrayAdapter<Simulacion>(Historial.this,android.R.layout.simple_list_item_1, lista_sims);
        lvDatos.setAdapter(simul);
    }

    public void nuevoCalculo(View v) {
        Intent nuevoCalc = new Intent(this, MainActivity.class);
        startActivity(nuevoCalc);
    }

}