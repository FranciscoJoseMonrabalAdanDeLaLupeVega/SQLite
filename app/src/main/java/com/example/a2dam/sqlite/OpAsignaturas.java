package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpAsignaturas extends AppCompatActivity implements View.OnClickListener{

    private Button insertar, verAsig;
    private EditText tNombre, tHoras;
    MyDBAdapter bbddAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op_asignaturas);

        bbddAdpter = new MyDBAdapter(this);
        bbddAdpter.open();

        insertar = (Button) findViewById(R.id.btnInsertarAsig);
        verAsig = (Button) findViewById(R.id.btnVerAsig);
        tNombre = (EditText) findViewById(R.id.tNombreAsig);
        tHoras = (EditText) findViewById(R.id.tHorasAsig);

        insertar.setOnClickListener(this);
        verAsig.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnInsertarAsig) {

            Asignatura asig = new Asignatura(0, tNombre.getText().toString(), tHoras.getText().toString());
            bbddAdpter.insertarAsignatura(asig);
            Toast.makeText(this, "Asignatura rellenada con exito", Toast.LENGTH_SHORT).show();
            tNombre.setText("");
            tHoras.setText("");

        } else {

            if (view.getId() == R.id.btnVerAsig) {

                Intent i = new Intent(this, VerAsignaturas.class);
                startActivity(i);
            }
        }
    }
}
