package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    SQLiteDatabase db;

    String nombre;
    String telefono;

    EditText edtNombre;
    EditText edtTelefono;

    Intent consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        TextView txtPath = findViewById(R.id.txtPath);
        edtNombre = findViewById(R.id.edtName);
        edtTelefono = findViewById(R.id.edtTelefono);

        //File storagePath = getApplication().getFilesDir();
        //String myDbPath = Environment.getExternalStorageDirectory().getPath() + "/testDB";

        //String myDbPath = storagePath + "/" + "testDB";
        //txtPath.setText(myDbPath);
        //txtPath.setText("Bienvenido");

        //try{
        //    db = SQLiteDatabase.openDatabase(myDbPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //    //db.close();
        //    txtPath.append("\n Exito al acceder a la base de datos!");
        //}catch(SQLiteException e){
        //   txtPath.append("\nError " + e.getMessage());
        //}

        //db.beginTransaction();
        //try{
            // A partir de aqui van todas las operaciones a realizarse en la base de datos
        //    db.execSQL("create table if not exists tblAMIGO ("

        //            + " recID integer PRIMARY KEY autoincrement, "

        //            + " name text, "

        //           + " phone text ); " );
        //    db.setTransactionSuccessful();
        //}catch(SQLiteException e){
        //    txtPath.append("\nError " + e.getMessage());
        //}finally{
        //    db.endTransaction();
        //}
    }

    /*
    public void agregarRegistro(View v){
        nombre = edtNombre.getText().toString();
        telefono = edtTelefono.getText().toString();
        db.beginTransaction();
        try{
            // A partir de aqui van todas las operaciones a realizarse en la base de datos
            db.execSQL( "insert into tblAMIGO(name, phone) values ('"+nombre+"', '"+telefono+"');" );
            Toast.makeText(this, "Exito al escribir sobre la base de datos!", Toast.LENGTH_SHORT).show();
            db.setTransactionSuccessful();
        }catch(SQLiteException e){
            Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }finally{
            db.endTransaction();
        }
    }
     */

    public void agregarRegistro(View v){
        String newEntry = edtNombre.getText().toString();
        String newEntry2 = edtTelefono.getText().toString();
        if(edtNombre.length()!= 0 && edtTelefono.length() != 0){
            AddData(newEntry, newEntry2);
            edtNombre.setText("");
            edtTelefono.setText("");
        }else{
            Toast.makeText(MainActivity.this, "Debes poner algo en los campos de texto!", Toast.LENGTH_LONG).show();
        }
    }

    public void consultarDB(View v){
        consulta = new Intent(this, Consulta.class);
        startActivity(consulta);
    }

    public void cerrarConexion(View v) {
        db.close();
    }

    public void AddData(String newEntry, String newEntry2) {

        boolean insertData = myDB.addData(newEntry, newEntry2);

        if(insertData==true){
            Toast.makeText(this, "Registro anadido exitosamente", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }
}
