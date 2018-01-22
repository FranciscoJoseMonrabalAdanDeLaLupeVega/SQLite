package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class VerEstudiantes extends AppCompatActivity implements View.OnClickListener {

    private Button verEstudiantes, verEstuCiclo, verEstuCurso, verEstuCicloCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_estudiantes);

        verEstudiantes = (Button) findViewById(R.id.btnVerEstudiantes);
        verEstuCiclo = (Button) findViewById(R.id.btnEstuCiclo);
        verEstuCurso = (Button) findViewById(R.id.btnEstuCurso);
        verEstuCicloCurso = (Button) findViewById(R.id.btnEstuCicloCurso);

        verEstudiantes.setOnClickListener(this);
        verEstuCiclo.setOnClickListener(this);
        verEstuCicloCurso.setOnClickListener(this);
        verEstuCurso.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(VerEstudiantes.this, FiltradoUsuarios.class);

        if (view.getId() == R.id.btnVerEstudiantes) {

            i.putExtra("boton", "todos");
            startActivity(i);
        } else {
            if (view.getId() == R.id.btnEstuCiclo) {

                i.putExtra("boton", "ciclo");
                startActivity(i);
            } else {
                if (view.getId() == R.id.btnEstuCurso) {

                    i.putExtra("boton", "curso");
                    startActivity(i);
                } else {
                    if (view.getId() == R.id.btnEstuCicloCurso) {

                        i.putExtra("boton", "cicloCurso");
                        startActivity(i);
                    }
                }
            }
        }
    }
}


