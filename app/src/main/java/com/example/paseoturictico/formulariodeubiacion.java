package com.example.paseoturictico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class formulariodeubiacion extends AppCompatActivity {
    EditText lugar,latitud,longitud;
    Conexionubicacion ubica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulariodeubiacion);
        lugar = findViewById(R.id.entradalugar);
        latitud = findViewById(R.id.entradalatitud);
        longitud = findViewById(R.id.entradalongitud);
        ubica = new Conexionubicacion(this,"nombredb",null,1);
    }
    public void guardar(View j){
        SQLiteDatabase sq = ubica.getWritableDatabase();
        ContentValues va = new ContentValues();
        va.put("lugar",lugar.getText().toString());
        va.put("latitud",latitud.getText().toString());
        va.put("longitud",longitud.getText().toString());
        lugar.setText("");
        latitud.setText("");
        longitud.setText("");
        Long res = sq.insert("ubicacion","lugar",va);
        Toast.makeText(this,"datos guardados "+res,Toast.LENGTH_LONG).show();

    }
    public void mostrar(View u){
        Intent gu = new Intent(getApplicationContext(),Recicla.class);
        startActivity(gu);
    }
}