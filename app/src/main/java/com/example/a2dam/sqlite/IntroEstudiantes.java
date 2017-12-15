package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntroEstudiantes extends AppCompatActivity {

    private EditText nombre, edad, curso, ciclo, notaMedia;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_estudiantes);

        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        curso = (EditText) findViewById(R.id.curso);
        ciclo = (EditText) findViewById(R.id.ciclo);
        notaMedia = (EditText) findViewById(R.id.notaMedia);
        guardar = (Button) findViewById(R.id.guardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Alumno alm = new Alumno();
                alm.setNombre("" + nombre.getText());
                alm.setEdad("" + edad.getText());
                alm.setCurso("" + curso.getText());
                alm.setCiclo("" + ciclo.getText());
                alm.setMedia("" + notaMedia.getText());

                MyDBAdapter.insertarAlumno(alm);

                Toast.makeText(IntroEstudiantes.this, "Bien rellenà", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(IntroEstudiantes.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
