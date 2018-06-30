package com.example.anthony.a20.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anthony.a20.Entities.Cursogrado;

import java.util.ArrayList;

public class CursoSpinnerAdapter extends ArrayAdapter<Cursogrado> {
    //AGREGAR VARIABLES
    Context context;
    ArrayList<Cursogrado> values;

    //RECURSO PARA OBTENER DATA Y FUNCIONES UTILITARIAS
    public CursoSpinnerAdapter(Context context,
                                    int textViewResourceId,
                                    ArrayList<Cursogrado> values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    public int getCount() {
        return values.size();
    }

    public Cursogrado getItem(int position) {
        return values.get(position);
    }

    //FUNCIONES PARA MOSTRAR SOLIDAS
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).getContenido());
        label.setTextSize(15);

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values.get(position).getContenido());
        label.setTextSize(15);

        return label;
    }
}