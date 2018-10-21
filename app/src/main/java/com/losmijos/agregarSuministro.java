package com.losmijos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class agregarSuministro extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner;
    String[] numero = {"1","2","3","4","5"};
    ImageView btnAceptar;
    ImageView btnCancelar;
    EditText articulo;
    int importancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_suministro);

        spinner = (Spinner) findViewById(R.id.spinner);
        btnAceptar = findViewById(R.id.btnAceptar);
        articulo = findViewById(R.id.txtSuministro);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numero));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                Toast.makeText(adapterView.getContext(),
                        (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
                importancia = (Integer) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAceptar:
                Intent i = getIntent();
                i.putExtra("articulo", articulo.getText().toString());
                i.putExtra("importancia", importancia);
                setResult(RESULT_OK, i);
                finish();
                break;
            case R.id.btnCancelar:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
