package com.losmijos;

<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
=======
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button botoncito;
=======
>>>>>>> d7bea50a99c0b0c87ea88f2157a469bf24263d82
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    ArrayList<entidad> listaDesastres;
    private adaptador adaptador;


>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        botoncito = findViewById(R.id.btn_siguiente);
        botoncito.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_siguiente:
                Intent i = new Intent(MainActivity.this, agregarSuministro.class);
                startActivity(i);
                break;
        }
=======
        lista = (ListView) findViewById(R.id.listaDestrastres);
        adaptador = new adaptador(this, getArrayListItems());
        lista.setAdapter(adaptador);
        listaDesastres = new ArrayList<entidad>();


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this, tab_1.class);
                Integer idDesastre =listaDesastres.get(position).getId_desastre();
                i.putExtra("id", idDesastre);
                MainActivity.this.startActivity(i);
            }
        });


>>>>>>> origin/master
    }

    public ArrayList<entidad> getArrayListItems(){
        ArrayList<entidad> listItems = new ArrayList<>();
        //inundaciones, terremotos, huracanes, incendios forestales, tornados, tsunami, temperaturas extremas, deslizamiento de tierra, sequias, erupción volcanica
        listItems.add(new entidad(R.drawable.flood,"Inundaciones","Aguas no te vayas a mojar", 1));
        listItems.add(new entidad(R.drawable.earthquake,"Terremotos","Choque de placas tectonicas",2));
        listItems.add(new entidad(R.drawable.wind,"Huracan","Viene el viento y tira las casas",3));
        listItems.add(new entidad(R.drawable.forest_fire,"Incendio Forestal","Fuego en nuestros bosques",4));
        listItems.add(new entidad(R.drawable.tornado,"Tornado","Vientorrazo que se lleva todo",5));
        listItems.add(new entidad(R.drawable.tsunami,"Tsunami","Olas gigantes chocan",6));
        listItems.add(new entidad(R.drawable.temperature,"Temperaturas extremas","Muy caliente",7));
        listItems.add(new entidad(R.drawable.landslide,"Deslizamiento de tierra","Montaña, colina o cerro se está cayendo",8));
        listItems.add(new entidad(R.drawable.drought,"Sequía","Se está secando la tierra",9));
        listItems.add(new entidad(R.drawable.volcano,"Erupciones volcanicas","Un volcan está apunto de eyacular",10));



        return listItems;
    }

}
