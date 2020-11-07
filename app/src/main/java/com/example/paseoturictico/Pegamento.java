package com.example.paseoturictico;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Pegamento extends RecyclerView.Adapter<Pegamento.ViewHolderpega> {
    ArrayList<Ubicacion>listaubicacion;
    public  Pegamento(ArrayList<Ubicacion> unamas){
        this.listaubicacion = unamas;

    }
    @NonNull
    @Override
    public ViewHolderpega onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View c = LayoutInflater.from(parent.getContext()).inflate(R.layout.registro,null,false);
        return new ViewHolderpega(c);
    }



    @Override
    public void onBindViewHolder(@NonNull Pegamento.ViewHolderpega holder, final int position) {
        holder.lugar.setText(listaubicacion.get(position).getLugar());
        holder.latitud.setText(listaubicacion.get(position).getLatitud());
        holder.longitud.setText(listaubicacion.get(position).getLongitud());
        holder.bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =  new Intent(view.getContext(),Mapa.class);
                in.putExtra("lugar",listaubicacion.get(position).getLugar());
                in.putExtra("latitud",listaubicacion.get(position).getLatitud());
                in.putExtra("longitud",listaubicacion.get(position).getLongitud());
                view.getContext().startActivity(in);
            }
        });



    }

    @Override
    public int getItemCount() {
        return listaubicacion.size();
    }
    public class ViewHolderpega extends RecyclerView.ViewHolder{
        TextView lugar ,latitud,longitud;
        Button bo;

        public ViewHolderpega(@NonNull View itemView) {
            super(itemView);
            lugar = itemView.findViewById(R.id.lugar);
            latitud = itemView.findViewById(R.id.latitud);
            longitud= itemView.findViewById(R.id.longitud);
            bo = itemView.findViewById(R.id.boton);
        }
    }
}
