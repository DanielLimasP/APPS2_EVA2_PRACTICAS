package com.example.eva2_8_sqlite3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateOne extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText edtOld, edtNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_one);

        edtOld = findViewById(R.id.edtOld);
        edtNew = findViewById(R.id.edtNew);

        myDB = new DatabaseHelper(this);
    }

    public void upd(View v){
        int updateData = myDB.updateData(edtOld.getText().toString(), edtNew.getText().toString());
        if(updateData > 0){
            Toast.makeText(this, "Registro actualizado exitosamente", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

}
