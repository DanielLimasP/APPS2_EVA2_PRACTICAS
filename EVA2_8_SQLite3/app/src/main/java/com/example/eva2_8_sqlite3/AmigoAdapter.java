package com.example.eva2_8_sqlite3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AmigoAdapter extends ArrayAdapter<Amigo> {

    Context context;
    int resource;
    ArrayList<Amigo> aAmigos;

    public AmigoAdapter(Context context, int resource, ArrayList<Amigo> object) {
        super(context, resource, object);
        this.context = context;
        this.resource = resource;
        this.aAmigos = object;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtNombre, txtTelefono;

        // convertView es el layout que representa una fila en la lista
        if(convertView == null){
            // Crear nuestro layout
            // Inflater
            LayoutInflater infla = ((Activity)context).getLayoutInflater();
            convertView = infla.inflate(resource, parent, false);


        }
        txtNombre = convertView.findViewById(R.id.txtNombre);
        txtTelefono = convertView.findViewById(R.id.txtTelefono);

        txtNombre.setText(aAmigos.get(position).getNombre());
        txtTelefono.setText(aAmigos.get(position).getTelefono());

        return convertView;
    }

}
