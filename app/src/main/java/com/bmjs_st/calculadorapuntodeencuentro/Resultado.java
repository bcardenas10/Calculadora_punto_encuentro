package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import static com.bmjs_st.calculadorapuntodeencuentro.MainActivity.configUnidad;

import java.io.Serializable;

public class Resultado extends AppCompatActivity implements Serializable {

    private TextView tv_vehiculo1, tv_vehiculo2, tv_dist1, tv_dist2, tv_vel1, tv_vel2, tv_tiempo, tv_distTotal, tv_uMetrica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tv_vehiculo1 = (TextView) findViewById(R.id.tv_vehiculo1);
        tv_vehiculo2 = (TextView) findViewById(R.id.tv_vehiculo2);
        tv_dist1 = (TextView) findViewById(R.id.tv_dist1);
        tv_dist2 = (TextView) findViewById(R.id.tv_dist2);
        tv_vel1 = (TextView) findViewById(R.id.tv_vel1);
        tv_vel2 = (TextView) findViewById(R.id.tv_vel2);
        tv_tiempo = (TextView) findViewById(R.id.tv_tiempo);
        tv_distTotal = (TextView) findViewById(R.id.tv_distTotal);
        tv_uMetrica = (TextView) findViewById(R.id.tv_uMetrica);

        //Obtener datos de la simulación
        Intent i = getIntent();
        Simulacion simulacion = (Simulacion)i.getSerializableExtra("Simu");

        //Mostrar datos SISTEMA METRICO
        if(configUnidad == false) {
            tv_vehiculo1.setText(simulacion.getNombreVeh1());
            tv_vehiculo2.setText(simulacion.getNombreVeh2());
            String distRVeh1 = String.format("%.1f", simulacion.getDistRVeh1());
            String distRVeh2 = String.format("%.1f", simulacion.getDistRVeh2());
            String VeloVeh1 = String.format("%.1f", simulacion.getVeloVeh1());
            String VeloVeh2 = String.format("%.1f", simulacion.getVeloVeh2());
            tv_dist1.setText(distRVeh1 + " KM");
            tv_dist2.setText(distRVeh2 + " KM");
            tv_vel1.setText(VeloVeh1 + " KM/H");
            tv_vel2.setText(VeloVeh2 + " KM/H");
            tv_tiempo.setText(simulacion.getTiempo());
            tv_distTotal.setText("Distancia Total: " + simulacion.getDistancia() + " KM");
        }
        else if(configUnidad == true) {
            tv_vehiculo1.setText(simulacion.getNombreVeh1());
            tv_vehiculo2.setText(simulacion.getNombreVeh2());
            String distRVeh1 = String.format("%.1f", simulacion.getDistRVeh1()*0.6214);
            String distRVeh2 = String.format("%.1f", simulacion.getDistRVeh2()*0.6214);
            String VeloVeh1 = String.format("%.1f", simulacion.getVeloVeh1()*0.6214);
            String VeloVeh2 = String.format("%.1f", simulacion.getVeloVeh2()*0.6214);
            tv_dist1.setText(distRVeh1 + " MI");
            tv_dist2.setText(distRVeh2 + " MI");
            tv_vel1.setText(VeloVeh1 + " MI/H");
            tv_vel2.setText(VeloVeh2 + " MI/H");
            tv_tiempo.setText(simulacion.getTiempo());
            String distT = String.format("%.1f", simulacion.getDistancia()*0.6214);
            tv_distTotal.setText("Distancia Total: " + distT + " MI");
            tv_uMetrica.setText("Sistema Anglosajón");
        }

    }

    public void nuevoCalculo(View v) {
        Intent nuevoCalc = new Intent(this, MainActivity.class);
        startActivity(nuevoCalc);
    }

    public void verHistorial(View v) {
        Intent historial = new Intent(this, Historial.class);
        startActivity(historial);
    }
}