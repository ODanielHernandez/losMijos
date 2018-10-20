package com.losmijos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptador extends BaseAdapter{

    private Context context;
    private ArrayList<entidad> listItem;

    public adaptador(Context context, ArrayList<entidad> listItem) {
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
        entidad Item = (entidad) getItem(position);


        convertView = LayoutInflater.from(context).inflate(R.layout.list, null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imgFoto);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        TextView contenido = (TextView) convertView.findViewById(R.id.contenido);

        imgFoto.setImageResource(Item.getImgFoto());
        titulo.setText(Item.getTitulo());
        contenido.setText(Item.getContenido());
        return convertView;
    }
}

