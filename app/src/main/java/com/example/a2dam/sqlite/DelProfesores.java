package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DelProfesores extends AppCompatActivity {

    private Button borrar;
    private EditText ID;
    private MyDBAdapter bbddAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_profesores);

        bbddAdapter = new MyDBAdapter(this);
        bbddAdapter.open();

        borrar = (Button) findViewById(R.id.btnBorrarProfesor);
        ID = (EditText) findViewById(R.id.tID_profesor);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bbddAdapter.borrarProfesor(Integer.parseInt(ID.getText().toString()));
                Toast.makeText(DelProfesores.this, "Alumno borrado con exito", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(DelProfesores.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
