package com.bmjs_st.calculadorapuntodeencuentro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
    }

    public void guardar(View v) {
        //Guardar config
        Toast notifyGuardar = Toast.makeText(getApplicationContext(), "Cambios guardados correctamente.", Toast.LENGTH_SHORT);
        notifyGuardar.show();
    }

    public void volver(View v) {
        Intent volverMain = new Intent(this, MainActivity.class);
        startActivity(volverMain);
    }
}