package com.example.paseoturictico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {
    EditText nombre,apellido,clave,genero;
    Conexionusuario us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        nombre = findViewById(R.id.entradanombre);
        apellido = findViewById(R.id.entradaapeliido);
        clave = findViewById(R.id.entradacontraseña);
        genero = findViewById(R.id.entradagenero);
        us=new Conexionusuario(this);
    }
    public  void ingresar(View m){
        Intent u =  new Intent(getApplicationContext(),formulariodeubiacion.class);
        Usuario um =  new Usuario();
        um.setNombre(nombre.getText().toString());
        um.setClave(clave.getText().toString());
        us.ingreso(um);
        Toast.makeText(this,"campo ingrsado",Toast.LENGTH_LONG).show();
        startActivity(u);
    }
}