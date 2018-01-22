package com.example.a2dam.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class VerAsignaturas extends AppCompatActivity {

    private ListView asignaturasList;
    private MyDBAdapter bbddAdapter;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_asignaturas);

        bbddAdapter = new MyDBAdapter(this);
        bbddAdapter.open();

        asignaturasList = (ListView) findViewById(R.id.asignaturasList);

        rellenaLista();

    }

    public void rellenaLista() {

        ArrayList<Asignatura> asignaturas = bbddAdapter.recuperarAsignaturas();
        Asignatura asig;
        ArrayList<String> nombreAsignaturaList = new ArrayList<String>();

        for (int i = 0; i > asignaturas.size(); i++) {

            asig = asignaturas.get(i);
            nombreAsignaturaList.add(asig.getNombre());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nombreAsignaturaList);
        asignaturasList.setAdapter(adapter);
    }
}
