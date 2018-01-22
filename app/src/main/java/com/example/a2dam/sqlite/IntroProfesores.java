package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntroProfesores extends AppCompatActivity {

    private EditText nombre, edad, curso, ciclo, tutor, despacho;
    private Button guardar;
    private MyDBAdapter bbddAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_profesores);

        bbddAdapter = new MyDBAdapter(this);
        bbddAdapter.open();

        nombre = (EditText) findViewById(R.id.profNombre);
        edad = (EditText) findViewById(R.id.profEdad);
        curso = (EditText) findViewById(R.id.profCurso);
        ciclo = (EditText) findViewById(R.id.profCiclo);
        tutor = (EditText) findViewById(R.id.profTutor);
        despacho = (EditText) findViewById(R.id.profDespacho);
        guardar = (Button) findViewById(R.id.profBotEnviar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Profesor prof = new Profesor();
                prof.setNombre("" + nombre.getText());
                prof.setEdad("" + edad.getText());
                prof.setCurso("" + curso.getText());
                prof.setCiclo("" + ciclo.getText());
                prof.setTutor("" + tutor.getText());
                prof.setDespacho("" + despacho.getText());

                bbddAdapter.insertarProfesor(prof);

                Toast.makeText(IntroProfesores.this, "Bien rellenà", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(IntroProfesores.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
