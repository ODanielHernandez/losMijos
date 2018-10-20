package com.losmijos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button botoncito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
