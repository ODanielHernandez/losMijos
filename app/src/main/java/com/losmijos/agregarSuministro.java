package com.losmijos;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class agregarSuministro extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    String[] numero = {"1","2","3","4","5"};
    ImageView add, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_suministro);

        spinner = (Spinner) findViewById(R.id.spinner);

        add = (ImageView) findViewById(R.id.btnAceptar);
        cancel = (ImageView) findViewById(R.id.btnCancelar);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numero));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                Toast.makeText(adapterView.getContext(),
                        (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(agregarSuministro.this, fragment_holder.class);
        //Integer idDesastre =listaDesastres.get(position).getId_desastre();
        //i.putExtra("id", idDesastre);
        switch (v.getId()){
            case R.id.btnCancelar:
                startActivity(i);
                break;
        }
    }
}
