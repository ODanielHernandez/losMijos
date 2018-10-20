package com.losmijos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button botoncito;
=======
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
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

>>>>>>> origin/master
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
