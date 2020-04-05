package com.example.eva2_8_sqlite3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    public void insertOne(View v){
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

    public void queryAll(View v){
        consulta = new Intent(this, Consulta.class);
        startActivity(consulta);
    }

    public void closeConn(View v) {
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
