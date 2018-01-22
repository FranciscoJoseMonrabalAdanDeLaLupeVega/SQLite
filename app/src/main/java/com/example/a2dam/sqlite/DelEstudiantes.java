package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DelEstudiantes extends AppCompatActivity {

    private Button borrar;
    private EditText ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_estudiantes);

        borrar = (Button) findViewById(R.id.btnBorrarEstudiante);
        ID = (EditText) findViewById(R.id.tID_estudiante);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDBAdapter.borrarAlumno(Integer.parseInt(ID.getText().toString()));
                Toast.makeText(DelEstudiantes.this, "Alumno borrado con exito", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(DelEstudiantes.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
