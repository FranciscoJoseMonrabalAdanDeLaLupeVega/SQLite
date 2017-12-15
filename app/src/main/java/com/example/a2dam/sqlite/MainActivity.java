package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button intrEstudiantes, intrProfesores, delEstudiante, delProfesores;

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

        intrEstudiantes.setOnClickListener(this);
        intrProfesores.setOnClickListener(this);
        delEstudiante.setOnClickListener(this);
        delProfesores.setOnClickListener(this);
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
    }
}
