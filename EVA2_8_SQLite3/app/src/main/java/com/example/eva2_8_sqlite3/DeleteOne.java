package com.example.eva2_8_sqlite3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteOne extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText nameToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_one);

        nameToDelete = findViewById(R.id.edtName);
        myDB = new DatabaseHelper(this);

    }

    public void del(View v){
        int deleteData = myDB.deleteData(nameToDelete.getText().toString());
        if(deleteData > 0){
            Toast.makeText(this, "Registro borrado exitosamente", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }
}
