package com.example.a21759217.appconsultartiempo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etLatitud;
    EditText etLongitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLatitud=findViewById(R.id.etLatitud);
        etLongitud=findViewById(R.id.etLongitud);
    }

    public void consultar(View v){
        String latitud=etLatitud.getText().toString().trim();
        String longitud=etLongitud.getText().toString().trim();

        if(latitud.isEmpty() || longitud.isEmpty()){
            Toast.makeText(this,"Debes rellenar todos los datos",Toast.LENGTH_LONG).show();

        }else {
            Intent i = new Intent(this, TiempoActivity.class);
            i.putExtra("LATITUD", latitud);
            i.putExtra("LONGITUD", longitud);
            startActivity(i);
        }

    }
}
