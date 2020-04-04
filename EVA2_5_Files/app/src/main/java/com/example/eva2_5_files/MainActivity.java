package com.example.eva2_5_files;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText edt1;
    final String ARCHIVO = "mi_archivo.txt";
    final int PERMISO_ESCRITURA = 1000;
    String sRuta_sd_card = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISO_ESCRITURA);
        }

        sRuta_sd_card = getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath();
                //Environment.getExternalStorageDirectory().getAbsolutePath();

        Toast.makeText(this, sRuta_sd_card, Toast.LENGTH_SHORT).show();
    }

    public void onRead(View v){
        try {
            //InputStream is = openFileInput(ARCHIVO);
            //FileInputStream fis = new FileInputStream(sRuta_sd_card + "/" + ARCHIVO);
            File file = new File(getExternalFilesDir(null), ARCHIVO);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String sCade;
            while((sCade = br.readLine()) != null){
                edt1.append(sCade);
                edt1.append("\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onWrite(View v){
        String sCade = edt1.getText().toString();
        try{
            //OutputStream os  = openFileOutput(ARCHIVO, 0);
            //FileOutputStream fos = new FileOutputStream(sRuta_sd_card + "/" + ARCHIVO);
            File file = new File(getExternalFilesDir(null), ARCHIVO);
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(sCade);
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
