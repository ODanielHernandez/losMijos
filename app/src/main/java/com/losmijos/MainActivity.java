package com.losmijos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listaDestrastres);
        adaptador = new adaptador(this, getArrayListItems());
        lista.setAdapter(adaptador);

    }

    private ArrayList<entidad> getArrayListItems(){
        ArrayList<entidad> listItems = new ArrayList<>();
        //inundaciones, terremotos, huracanes, incendios forestales, tornados, tsunami, temperaturas extremas, deslizamiento de tierra, sequias, erupción volcanica
        listItems.add(new entidad(R.drawable.flood,"Inundaciones","Aguas no te vayas a mojar"));
        listItems.add(new entidad(R.drawable.earthquake,"Terremotos","Choque de placas tectonicas"));
        listItems.add(new entidad(R.drawable.wind,"Huracan","Viene el viento y tira las casas"));
        listItems.add(new entidad(R.drawable.forest_fire,"Incendio Forestal","Fuego en nuestros bosques"));
        listItems.add(new entidad(R.drawable.tornado,"Tornado","Vientorrazo que se lleva todo"));
        listItems.add(new entidad(R.drawable.tsunami,"Tsunami","Olas gigantes chocan"));
        listItems.add(new entidad(R.drawable.temperature,"Temperaturas extremas","Muy caliente"));
        listItems.add(new entidad(R.drawable.landslide,"Deslizamiento de tierra","Montaña, colina o cerro se está cayendo"));
        listItems.add(new entidad(R.drawable.drought,"Sequía","Se está secando la tierra"));
        listItems.add(new entidad(R.drawable.volcano,"Erupciones volcanicas","Un volcan está apunto de eyacular"));

        return listItems;
    }

}
