package com.lunijami.nodehood.modelo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lunijami.nodehood.MiAdaptadorPedidos;
import com.lunijami.nodehood.R;

import java.util.ArrayList;

/**
 * @author Miguel Parra
 */
public class MiAdaptadorChats extends RecyclerView.Adapter<MiAdaptadorPedidos.MiContenedorDeVistas>{

    private ArrayList<String> lista_chats = new java.util.ArrayList<>();

    public MiAdaptadorChats(ArrayList<String> lista_chats) {
        this.lista_chats = lista_chats;
    }

    @NonNull
    @Override
    public MiAdaptadorPedidos.MiContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        TextView tv_titulo = vista.findViewById(R.id.product_title);
        TextView tv_descripcion = vista.findViewById(R.id.product_description);
        ImageView imagen = vista.findViewById(R.id.imagen_producto);
        MiAdaptadorPedidos.MiContenedorDeVistas contenedor = new MiAdaptadorPedidos.MiContenedorDeVistas(vista);
        Log.d("Contenedor", "Creando contenedor de vistas: ");
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptadorPedidos.MiContenedorDeVistas holder, int position) {
        String c = lista_chats.get(position);
        holder.tv_titulo.setText(c);



        Log.d("Contenedor", "Vinculado la posicion" + position);
    }

    @Override
    public int getItemCount() {
        return lista_chats.size();
    }

    public static class MiContenedorDeVistas extends RecyclerView.ViewHolder{
        public TextView tv_titulo;

        public MiContenedorDeVistas(View vista) {
            super(vista);
            this.tv_titulo = vista.findViewById(R.id.product_title);

        }

    }
}
