package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class Consulta extends AppCompatActivity {

    DatabaseHelper myDB;
    SQLiteDatabase db;
    ListView listaAmigos;
    AmigoAdapter amigoAdapter;
    Amigo[] a = new Amigo[100];
    //Amigo[] b = {
     //       new Amigo("Juan","5556101"),
    //};
    ArrayList<Amigo> amigos = new ArrayList<>();
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        myDB = new DatabaseHelper(this);

        listaAmigos = findViewById(R.id.lstAmigos);

        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "No hay registros en la base de datos!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                amigos.add(new Amigo(data.getString(1), data.getString(2)));
                amigoAdapter = new AmigoAdapter(this,
                        R.layout.layout_amigo,
                        amigos);
                listaAmigos.setAdapter(amigoAdapter);
            }
        }
        /*
        File storagePath = getApplication().getFilesDir();
        String myDbPath = storagePath + "/" + "testDB";
        try{
            db = SQLiteDatabase.openDatabase(myDbPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
            Toast.makeText(this, "Exito al acceder a la base de datos!" , Toast.LENGTH_SHORT).show();
        }catch(SQLiteException e){
            Toast.makeText(this, "Error " +e.getMessage() , Toast.LENGTH_SHORT).show();
        }
        String sql = "select * from tblAmigo";
        Cursor c1 = db.rawQuery(sql, null);
        c1.moveToPosition(-1);
        while(c1.moveToNext()){
            int recId = c1.getInt(0);
            String nombre = c1.getString(1);
            String telefono = c1.getString(c1.getColumnIndex("phone"));
            Amigo amigo = new Amigo(nombre, telefono);
            a[cont] = amigo;
            amigoAdapter.notifyDataSetChanged();
        }
        c1.close();
        */


    }
}
