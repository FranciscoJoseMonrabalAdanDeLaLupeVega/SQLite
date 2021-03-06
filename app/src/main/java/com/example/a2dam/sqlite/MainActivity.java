package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button intrEstudiantes, intrProfesores, delEstudiante, delProfesores, verEstudiantes, asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBAdapter bd = new MyDBAdapter(this);
        bd.open();

        intrEstudiantes = (Button) findViewById(R.id.intrEstudiantes);
        intrProfesores = (Button) findViewById(R.id.intrProfesores);
        delEstudiante = (Button) findViewById(R.id.delEstudiantes);
        delProfesores = (Button) findViewById(R.id.delProfesores);
        verEstudiantes = (Button) findViewById(R.id.btnVerEstudiantes);
        asignaturas = (Button) findViewById(R.id.btnAsig);

        intrEstudiantes.setOnClickListener(this);
        intrProfesores.setOnClickListener(this);
        delEstudiante.setOnClickListener(this);
        delProfesores.setOnClickListener(this);
        verEstudiantes.setOnClickListener(this);
        asignaturas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.intrEstudiantes) {

            Intent i = new Intent(MainActivity.this, IntroEstudiantes.class);
            startActivity(i);
        }

        if (view.getId() == R.id.intrProfesores) {

            Intent i = new Intent(MainActivity.this, IntroProfesores.class);
            startActivity(i);
        }

        if (view.getId() == R.id.delEstudiantes) {

            Intent i = new Intent(MainActivity.this, DelEstudiantes.class);
            startActivity(i);
        }

        if (view.getId() == R.id.delProfesores) {

            Intent i = new Intent(MainActivity.this, DelProfesores.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btnVerEstudiantes) {

            Intent i = new Intent(MainActivity.this, VerEstudiantes.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btnAsig) {

            Intent i = new Intent(MainActivity.this, OpAsignaturas.class);
            startActivity(i);
        }
    }
}
