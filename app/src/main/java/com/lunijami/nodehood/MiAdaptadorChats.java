package com.lunijami.nodehood;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.lunijami.nodehood.modelo.entidades.Usuario;

import java.util.ArrayList;

public class MiAdaptadorChats  extends RecyclerView.Adapter<MiAdaptadorChats.ViewHolderDatos>{
    ArrayList<Usuario> listChats;

    public MiAdaptadorChats(ArrayList<Usuario> listChats) {
        this.listChats = listChats;
    }

    @NonNull
    @Override
    public MiAdaptadorChats.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_card, parent, false);
        TextView dato = vista.findViewById(R.id.user_name);
        ImageView imagen = vista.findViewById(R.id.imagen_usuario);
        ViewHolderDatos contenedor = new ViewHolderDatos(vista);
        Log.d("Contenedor", "Creando contenedor de vistas: ");
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptadorChats.ViewHolderDatos holder, int position) {
        Usuario user = listChats.get(position);
        holder.dato.setText(user.getNombre());
        holder.imagen.setImageDrawable(user.getFoto());
    }

    @Override
    public int getItemCount() {
        return listChats.size();
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;
        ImageView imagen;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.user_name);
            imagen = (ImageView) itemView.findViewById(R.id.imagen_usuario);
        }

    }
}
