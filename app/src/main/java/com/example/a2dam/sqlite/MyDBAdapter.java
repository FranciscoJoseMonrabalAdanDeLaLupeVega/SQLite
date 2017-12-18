package com.example.a2dam.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 2dam.
 */
public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "dbColegio.db";
    private static final String DATABASE_TABLE = "alumnos";
    private static final String DATABASE_TABLE2 = "profesores";
    private static final int DATABASE_VERSION = 1;

    private static final String ID = "_id";
    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String CURSO = "curso";
    private static final String MEDIA = "media";
    private static final String TUTOR = "tutor";
    private static final String DESPACHO = "despacho";

    private static final String DATABASE_CREATE = "CREATE TABLE "+DATABASE_TABLE+" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, media text);" +
            "CREATE TABLE " + DATABASE_TABLE2 +" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, tutor text, despacho text)";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+DATABASE_TABLE+";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private static SQLiteDatabase db;

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

    public static void insertarAlumno(Alumno alm){

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

    public static void insertarProfesor(Profesor prof){

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

    public static void borrarAlumno(int row) {

        db.delete(DATABASE_TABLE, ID + "=" + row, null);
    }

    public static void borrarProfesor (int row) {

        db.delete(DATABASE_TABLE2, ID + "=" + row, null);
    }
    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }

    }
}
