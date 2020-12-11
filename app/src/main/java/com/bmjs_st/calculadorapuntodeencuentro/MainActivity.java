package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Serializable {

    private EditText et_veh1, tn_velo1, et_veh2, tn_velo2, tn_distancia;

    public static ArrayList<Simulacion> lista_sims = new ArrayList<>();

    public static boolean configUnidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_veh1 = (EditText) findViewById(R.id.et_veh1);
        tn_velo1 = (EditText) findViewById(R.id.tn_velo1);
        et_veh2 = (EditText) findViewById(R.id.et_veh2);
        tn_velo2 = (EditText) findViewById(R.id.tn_velo2);
        tn_distancia = (EditText) findViewById(R.id.tn_distancia);

        //Hints
        if(configUnidad == false) {
            tn_velo1.setHint("KM/H");
            tn_velo2.setHint("KM/H");
            tn_distancia.setHint("Distancia en KM");
        } else if(configUnidad == true) {
            tn_velo1.setHint("MI/H");
            tn_velo2.setHint("MI/H");
            tn_distancia.setHint("Distancia en MI");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void calcular(View v) {

        //CAMPOS VACIOS
        if(et_veh1.getText().toString().isEmpty()) { et_veh1.setText("Vehículo 1"); }
        if(et_veh2.getText().toString().isEmpty()) { et_veh2.setText("Vehículo 2"); }
        if(tn_velo1.getText().toString().isEmpty() || tn_velo2.getText().toString().isEmpty() || tn_distancia.getText().toString().isEmpty())
        {
            Toast msj_error = Toast.makeText(getApplicationContext(), "Completa los campos de velocidad y distancia.", Toast.LENGTH_SHORT);
            msj_error.show();
            return;
        }

        //VALIDACIONES
        double distancia = Double.parseDouble(String.valueOf(tn_distancia.getText()));
        double velo1 = Double.parseDouble(String.valueOf(tn_velo1.getText()));
        double velo2 = Double.parseDouble(String.valueOf(tn_velo2.getText()));

        //VELOCIDAD
        if(velo1 < 0 || velo2 < 0) {
            Toast msj_error = Toast.makeText(getApplicationContext(), "La velocidad no puede ser menor a 0.", Toast.LENGTH_SHORT);
            msj_error.show();
            return;
        }
        if(velo1 == 0 && velo2 == 0) {
            Toast msj_error = Toast.makeText(getApplicationContext(), "Solo puede haber 1 vehículo con velocidad 0.", Toast.LENGTH_SHORT);
            msj_error.show();
            return;
        }
        if(velo1 > 250 || velo2 > 250) {
            Toast msj_error = Toast.makeText(getApplicationContext(), "La velocidad de los vehículos no puede ser mayor a 250.", Toast.LENGTH_SHORT);
            msj_error.show();
            return;
        }

        //DISTANCIA
        if(distancia < 0 || distancia > 1000) {
            Toast msj_error = Toast.makeText(getApplicationContext(), "La distancia debe estar entre 0 y 1000.", Toast.LENGTH_SHORT);
            msj_error.show();
            return;
        }

        //SISTEMA ANGLOSAJÓN - CONVERTIR MI A KM
        if(configUnidad == true) {
            distancia = distancia/0.62137;
            velo1 = velo1/0.62137;
            velo2 = velo2/0.62137;
        }

        //CÁLCULOS
        double sumaVelos = velo1 + velo2; //Suma de velocidades en metros/segundos
        double tiempoEstimado = distancia / sumaVelos; //Tiempo estimado en segundos

        double distancia1 = velo1*tiempoEstimado; //Distancia recorrida por veh1 en metros
        double distancia2 = velo2*tiempoEstimado; //Distancia recorrida por veh2 en metros

        //FORMATO DE TIEMPO ESTIMADO
        int hours = (int) tiempoEstimado;
        int minutes = (int) (tiempoEstimado * 60) % 60;
        int seconds = (int) (tiempoEstimado * (60*60)) % 60;
        String horas, minutos, segundos;
        horas = String.format("%s", hours);
        minutos = String.format("%s", minutes);
        segundos = String.format("%s", seconds);
        if(hours < 10) { horas = String.format("0%s", hours); }
        if(minutes < 10) { minutos = String.format("0%s", minutes); }
        if(seconds < 10) { segundos = String.format("0%s", seconds); }
        String tiempoFormat = horas + ":" + minutos + ":" + segundos;

        //Crear objeto Simulación y agregar a la lista
        Simulacion nueva_sim = new Simulacion(et_veh1.getText().toString(), velo1, distancia1, et_veh2.getText().toString(), velo2, distancia2, tiempoFormat, distancia);
        lista_sims.add(nueva_sim);

        Intent resultado = new Intent(MainActivity.this, Resultado.class);
        resultado.putExtra("Simu", nueva_sim);
        startActivity(resultado);
    }

    public void verHistorial(View v) {
        Intent historial = new Intent(this, Historial.class);
        startActivity(historial);
    }

    public void config(View v){
        Intent config = new Intent(this, Configuracion.class);
        startActivity(config);
    }

}