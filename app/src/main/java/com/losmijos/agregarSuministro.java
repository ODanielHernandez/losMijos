package com.losmijos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class agregarSuministro extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    Integer value;
    String[] numero = {"1","2","3","4","5"};
    ImageView add, cancel;
    EditText etSuministro;

    AdminBD baseDatos = new AdminBD(this);

    String[] tablas = {"inundaciones","terremotos","huracanes","tornados","tsunamis","temperaturasExtremas","sequias","erupcionVolcanica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_suministro);

        Bundle extras = this.getIntent().getExtras();
        value = extras.getInt("id");

        etSuministro = findViewById(R.id.txtSuministro);
        spinner = (Spinner) findViewById(R.id.spinner);

        add = (ImageView) findViewById(R.id.btnAceptar);
        cancel = (ImageView) findViewById(R.id.btnCancelar);

        add.setOnClickListener(this);
        cancel.setOnClickListener(this);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numero));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
             //   Toast.makeText(adapterView.getContext(),(String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });
    }

    @Override
    public void onClick(View v) {
        //Intent i = new Intent(agregarSuministro.this, fragment_holder.class);
        //i.putExtra("id", value);
        switch (v.getId()){
            case R.id.btnCancelar:
                finish();
                //startActivity(i);
                break;
            case R.id.btnAceptar:
                //Aquí va la cosa pa agregar en la base de datos
                SQLiteDatabase baseD = baseDatos.getWritableDatabase();
                baseDatos.insertarRegistro(baseD, etSuministro.getText().toString(), spinner.getSelectedItemPosition()+1, tablas[value]);
                finish();
                //startActivity(i);
                break;
        }
    }
}
