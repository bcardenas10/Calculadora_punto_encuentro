package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.bmjs_st.calculadorapuntodeencuentro.MainActivity.configUnidad;

public class Configuracion extends AppCompatActivity {

    RadioButton rb_metrico, rb_anglosajon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        rb_metrico = (RadioButton) findViewById(R.id.rb_metrico);
        rb_anglosajon = (RadioButton) findViewById(R.id.rb_anglosajon);

        if(configUnidad == false) {
            rb_metrico.setChecked(true);
        } else if(configUnidad == true) {
            rb_anglosajon.setChecked(true);
        }
    }

    public void guardar(View v) {
        if(rb_metrico.isChecked())
        {
            configUnidad = false;
            Toast notifyGuardar = Toast.makeText(getApplicationContext(), "Cambios guardados correctamente.", Toast.LENGTH_SHORT);
            notifyGuardar.show();
        }
        else if(rb_anglosajon.isChecked())
        {
            configUnidad = true;
            Toast notifyGuardar = Toast.makeText(getApplicationContext(), "Cambios guardados correctamente.", Toast.LENGTH_SHORT);
            notifyGuardar.show();
        }
    }

    public void volver(View v) {
        Intent volverMain = new Intent(this, MainActivity.class);
        startActivity(volverMain);
    }
}