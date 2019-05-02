package com.example.alumno.clase5;

import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import android.graphics.BitmapFactory;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<PersonaModel> personas;
    private MyOnItemClick listener;
    private Handler myHanler;
    public MyAdapter(List<PersonaModel> personas,MyOnItemClick listener,Handler myHanler){
        this.personas = personas;
        this.listener = listener;
        this.myHanler = myHanler;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recy,parent,false);

        MyViewHolder myViewHoleder = new MyViewHolder(v,listener);
        return myViewHoleder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Aca se debe llamar al hilo para obtener la imagen
        PersonaModel p = this.personas.get(position);

        holder.tvEdad.setText(p.getTelefono());
        holder.tvNombre.setText(p.getNombre());
        holder.tvApellido.setText(p.getApellido());

        if(!p.getProcesar()){
            MyThread hilo2 = new MyThread(this.myHanler,p.getImagen(),2,position);
            p.setProcesar(true);
            hilo2.start();
        }
        else{
            if(p.getImagenValor() != null){
                holder.viewImagen.setImageBitmap(BitmapFactory.decodeByteArray(p.getImagenValor(),0,p.getImagenValor().length));
            }
        }

        holder.setPosition(position);
    }

    public List<PersonaModel> SetPersonas(List<PersonaModel> pers){
        this.personas = pers;
        return this.personas;
    }
    public void SetImagenPer(byte[] imagen,int position){
        PersonaModel p = this.personas.get(position);
        p.setImagenValor(imagen);
    }
    @Override
    public int getItemCount() {
        return this.personas.size();
    }


}
