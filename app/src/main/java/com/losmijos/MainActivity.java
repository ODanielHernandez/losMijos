package com.losmijos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ListView lista;
    ArrayList<entidad> listaDesastres;
    private adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista = (ListView) findViewById(R.id.listaDestrastres);
        adaptador = new adaptador(this, getArrayListItems());
        lista.setAdapter(adaptador);
        listaDesastres = new ArrayList<entidad>();


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this, fragment_holder.class);
                //Integer idDesastre =listaDesastres.get(position).getId_desastre();
                //i.putExtra("id", idDesastre);
                MainActivity.this.startActivity(i);
            }
        });


    }

    public ArrayList<entidad> getArrayListItems(){
        ArrayList<entidad> listItems = new ArrayList<>();
        //inundaciones, terremotos, huracanes, incendios forestales, tornados, tsunami, temperaturas extremas, deslizamiento de tierra, sequias, erupción volcanica
        listItems.add(new entidad(R.drawable.flood,"Inundaciones","Aguas no te vayas a mojar", 1));
        listItems.add(new entidad(R.drawable.earthquake,"Terremotos","Choque de placas tectonicas",2));
        listItems.add(new entidad(R.drawable.wind,"Huracan","Viene el viento y tira las casas",3));
        listItems.add(new entidad(R.drawable.tornado,"Tornado","Vientorrazo que se lleva todo",4));
        listItems.add(new entidad(R.drawable.tsunami,"Tsunami","Olas gigantes chocan",5));
        listItems.add(new entidad(R.drawable.temperature,"Temperaturas extremas","Muy caliente",6));
        listItems.add(new entidad(R.drawable.drought,"Sequía","Se está secando la tierra",7));
        listItems.add(new entidad(R.drawable.volcano,"Erupciones volcanicas","Un volcan está apunto de eyacular",8));



        return listItems;
    }

}
