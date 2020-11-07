package com.example.paseoturictico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class Recicla extends AppCompatActivity {
    RecyclerView reci;
    Conexionubicacion ubi;
    ArrayList<Ubicacion>listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicla);
        ubi = new Conexionubicacion(this,"nombredb",null,1);
        listado = new ArrayList<>();
        reci= findViewById(R.id.recicl);
        reci.setLayoutManager(new LinearLayoutManager(this));
        listita();
        Pegamento pe =  new Pegamento(listado);
        reci.setAdapter(pe);

    }
    public void listita(){
        SQLiteDatabase db = ubi.getReadableDatabase();
        Ubicacion h = null;
        Cursor c = db.rawQuery("SELECT * FROM ubicacion",null);
        while (c.moveToNext()){
            h = new Ubicacion();
            h.setId(c.getInt(0));
            h.setLugar(c.getString(1));
            h.setLatitud(c.getString(2));
            h.setLongitud(c.getString(3));
            listado.add(h);
        }
    }
}