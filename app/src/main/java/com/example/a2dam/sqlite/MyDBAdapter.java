package com.example.a2dam.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 2dam.
 */
public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "dbColegioo.db";
    private static final String DATABASE_TABLE = "alumnos";
    private static final String DATABASE_TABLE2 = "profesores";
    private static final String DATABASE_TABLE_ASIG = "asignaturas";
    private static final int DATABASE_VERSION = 1;

    private static final String ID = "_id";
    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String CURSO = "curso";
    private static final String MEDIA = "media";
    private static final String TUTOR = "tutor";
    private static final String HORAS = "horas";
    private static final String DESPACHO = "despacho";

    private static final String DATABASE_CREATE = "CREATE TABLE "+DATABASE_TABLE+" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, media text);";
    private static final String DATABASE_CREATE2 = "CREATE TABLE " + DATABASE_TABLE2 +" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, tutor text, despacho text);";
    private static final String DATABASE_CREATE_ASIGNATURAS = "CREATE TABLE " + DATABASE_TABLE_ASIG +" (_id integer primary key autoincrement, nombre text, horas text);";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+DATABASE_TABLE+";";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS "+DATABASE_TABLE2+";";
    private static final String DATABASE_DROP_ASIG = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ASIG+";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarAlumno(Alumno alm){

        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,alm.getNombre());
        newValues.put(EDAD,alm.getEdad());
        newValues.put(CURSO,alm.getCurso());
        newValues.put(CICLO, alm.getCiclo());
        newValues.put(MEDIA,alm.getMedia());
        db.insert(DATABASE_TABLE,null,newValues);
    }

    public void insertarProfesor(Profesor prof){

        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,prof.getNombre());
        newValues.put(EDAD,prof.getEdad());
        newValues.put(CURSO,prof.getCurso());
        newValues.put(CICLO, prof.getCiclo());
        newValues.put(TUTOR,prof.getTutor());
        newValues.put(DESPACHO,prof.getDespacho());
        db.insert(DATABASE_TABLE2,null,newValues);
    }

    public void borrarAlumno(int row) {

        db.delete(DATABASE_TABLE, ID + "=" + row, null);
    }

    public void borrarProfesor (int row) {

        db.delete(DATABASE_TABLE2, ID + "=" + row,null);
    }

    public void insertarAsignatura(Asignatura asig){

        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,asig.getNombre());
        newValues.put(HORAS,asig.getHoras());

        db.insert(DATABASE_TABLE2,null,newValues);
    }

    public ArrayList<Asignatura> recuperarAsignaturas(){
        ArrayList<Asignatura> asignaturaList = new ArrayList<Asignatura>();
        Asignatura asig;
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE_ASIG,null,null,null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                asig = new Asignatura();

                asig.setId(cursor.getInt(0));
                asig.setNombre(cursor.getString(1));
                asig.setHoras(cursor.getString(2));

                asignaturaList.add(asig);
            }while (cursor.moveToNext());
        }
        return asignaturaList;
    }

    public ArrayList<Alumno> recuperarAlumunos(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                Alumno alumno = new Alumno();

                alumno.setNombre(cursor.getString(0));
                alumno.setEdad(cursor.getString(1));
                alumno.setCurso(cursor.getString(2));
                alumno.setCiclo(cursor.getString(3));
                alumno.setMedia(cursor.getString(4));

                alumnos.add(alumno);
            }while (cursor.moveToNext());
        }
        return alumnos;
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE2);
            db.execSQL(DATABASE_CREATE_ASIGNATURAS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            db.execSQL(DATABASE_DROP2);
            db.execSQL(DATABASE_DROP_ASIG);
            onCreate(db);
        }

    }
}
