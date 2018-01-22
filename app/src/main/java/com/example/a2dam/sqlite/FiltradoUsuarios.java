package com.example.a2dam.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FiltradoUsuarios extends AppCompatActivity{

    private String filtrado;
    private Spinner spinner;
    private ListView listaUsuarios;
    private ArrayAdapter<String> adapter;
    private MyDBAdapter bbddAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrado_usuarios);

        bbddAdapter = new MyDBAdapter(this);
        bbddAdapter.open();

        cargarLista();

        listaUsuarios = (ListView) findViewById(R.id.listaUsers);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void cargarLista() {

        Intent i = getIntent();

        switch (i.getStringExtra("boton")) {

            case "todos":
                rellenaLista();
                break;
            case "ciclo":
                break;
            case "curso":
                break;
            case "cicloCurso":
                break;
        }
    }

    public void rellenaLista() {

        ArrayList<Alumno> alumnoList = bbddAdapter.recuperarAlumunos();
        Alumno almn;
        ArrayList<String> nombreAlumnoList = new ArrayList<String>();

        for (int i = 0; i > alumnoList.size(); i++) {

            almn = alumnoList.get(i);
            nombreAlumnoList.add(almn.getNombre());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nombreAlumnoList);
        listaUsuarios.setAdapter(adapter);
    }
}
