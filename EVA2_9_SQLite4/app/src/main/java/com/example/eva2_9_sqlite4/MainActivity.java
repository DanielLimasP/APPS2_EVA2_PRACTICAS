package com.example.eva2_9_sqlite4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMsg =findViewById(R.id.txtVw);

        //File storagePath = getApplication().getFilesDir();
        //String myDbPath = storagePath + "/" + "testDB";

        String SDcardPath = Environment.getExternalStorageDirectory().getPath() + "/tblAMIGOS";
        txtMsg.setText(SDcardPath);

        try{
            db = SQLiteDatabase.openDatabase(SDcardPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
            //db.close();
            txtMsg.append("\n Exito al acceder a la base de datos!");
        }catch(SQLiteException e){
            txtMsg.append("\nError " + e.getMessage());
        }

        db.beginTransaction();
        try{
            // A partir de aqui van todas las operaciones a realizarse en la base de datos
            db.execSQL("create table IF NOT EXISTS tblAMIGO  ("

                    + " recID integer PRIMARY KEY autoincrement, "

                    + " name text, "

                    + " phone text ); " );

            db.execSQL( "insert into tblAMIGO(name, phone) values ('Daniel', '555-1111');" );
            db.execSQL( "insert into tblAMIGO(name, phone) values ('Laura', '555-2222');" );
            db.execSQL( "insert into tblAMIGO(name, phone) values ('Antonio', '555-3333');" );
            txtMsg.append("\n Exito al escribir sobre la base de datos!");
            db.setTransactionSuccessful();
        }catch(SQLiteException e){
            txtMsg.append("\nError " + e.getMessage());
        }finally{
            db.endTransaction();
        }

    }// onCreate
}// class
