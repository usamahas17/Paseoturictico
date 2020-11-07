package com.example.paseoturictico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Conexionusuario {
    Context l;
    ArrayList<Usuario> usa ;
    Usuario us;
    SQLiteDatabase sql;
    String bd = "bdusuario";
    String table =  "create table if not exists usuario(id integer primary key, nombre text,clave text)";
    public Conexionusuario(Context l){
        this.l = l;
        sql = l.openOrCreateDatabase(bd,l.MODE_PRIVATE,null);
        sql.execSQL(table);
        us = new Usuario();

    }
    public  Boolean ingreso(Usuario us){
        if(buscando(us.getNombre())==0){
            ContentValues valore= new ContentValues();
            valore.put("nombre",us.getNombre());
            valore.put("clave",us.getClave());
            return (sql.insert("usuario",null,valore)>0);

        }else {
            return false;
        }



    }public int buscando(String j){
        int o = 0;
        usa = selecion();
        for (Usuario u :usa){
            if(u.getNombre().equals(j)){
                o++;
            }
        }return o;



    }
    public  ArrayList<Usuario> selecion(){
        ArrayList<Usuario> k = new ArrayList<>();
        k.clear();
        Cursor c = sql.rawQuery("SELECT * FROM usuario",null);
        if(c!=null && c.moveToFirst()){
            do {
                Usuario us = new Usuario();
                us.setId(c.getInt(0));
                us.setNombre(c.getString(1));
                us.setClave(c.getString(2));
                k.add(us);

            }while (c.moveToNext());

        }return k;
    }
    public  int inicio(String nombre,String clave){
        int y  = 0;
        Cursor c = sql.rawQuery("SELECT * FROM usuario",null);
        if(c!= null && c.moveToFirst()){
            do {
                if(c.getString(1).equals(nombre)&&c.getString(2).equals(clave)){
                    y++;

                }

            }while (c.moveToNext());


        }return y;

    }
}
