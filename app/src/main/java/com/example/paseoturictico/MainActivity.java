package com.example.paseoturictico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre,clave;
    Conexionusuario un;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombredeentrada);
        clave = findViewById(R.id.entradadeclave);
        un = new Conexionusuario(this);
    }
    public void entrar(View d){
        String nomb,clav;
        nomb = nombre.getText().toString();
        clav = clave.getText().toString();
        if(nomb.equals("") && clav.equals("")){
            Toast.makeText(this,"campo vacio",Toast.LENGTH_LONG).show();
        }
        if(un.inicio(nomb,clav)==1){
            Intent in = new Intent(getApplicationContext(),formulariodeubiacion.class);
            Toast.makeText(this,"usuario reconocido",Toast.LENGTH_LONG).show();
            startActivity(in);
        }


    }
    public void registrar(View x ){
        Intent in = new Intent(getApplicationContext(),Formulario.class);
        startActivity(in);
    }
}