package com.losmijos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptador_mochila extends BaseAdapter {

    private Context context;
    private ArrayList<entidad_mochila> listItem;

    public adaptador_mochila(Context context, ArrayList<entidad_mochila> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {

        return listItem.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        entidad_mochila Item = (entidad_mochila) getItem(position);


        convertView = LayoutInflater.from(context).inflate(R.layout.mochila_list, null);

        TextView nombre = (TextView) convertView.findViewById(R.id.nombre);
        TextView prioridad = (TextView) convertView.findViewById(R.id.prioridad);
        CheckBox obtenido = (CheckBox) convertView.findViewById(R.id.obtenido);


        nombre.setText(Item.getNombre());
        prioridad.setText(Item.getPrioridad());
        obtenido.setChecked(Item.getObtenido());

        return convertView;
    }
}
