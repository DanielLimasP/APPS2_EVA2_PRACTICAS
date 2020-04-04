package com.example.eva2_4_files_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView txtVw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVw1 = findViewById(R.id.txtVw1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        InputStream inputStream = getResources().openRawResource(R.raw.lorem);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String sCade;

        try{
            while((sCade = bufferedReader.readLine()) != null){
                txtVw1.append(sCade);
                txtVw1.append("\n");
            }
            bufferedReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
