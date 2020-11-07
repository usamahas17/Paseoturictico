package com.example.paseoturictico;

public class Ubicacion {
    String  lugar,latitud,longitud;
    int id;
    public Ubicacion()
    {

    }
    public Ubicacion(String lugar,String latitud,String longitud,int id){
        this.id =  id;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
