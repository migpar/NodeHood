package com.lunijami.nodehood;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lunijami.nodehood.modelo.entidades.Pedido;

import java.util.ArrayList;

/**
 * @author Miguel Parra
 */
public class MiAdaptadorPedidos extends RecyclerView.Adapter<MiAdaptadorPedidos.MiContenedorDeVistas> {

    private ArrayList<Pedido> lista_pedidos = new ArrayList<>();

    public MiAdaptadorPedidos(ArrayList<Pedido> lista_contactos) {
        this.lista_pedidos = lista_contactos;
    }

    @NonNull
    @Override
    public MiContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        TextView tv_titulo = vista.findViewById(R.id.product_title);
        TextView tv_descripcion = vista.findViewById(R.id.product_description);
        ImageView imagen = vista.findViewById(R.id.imagen_producto);
        MiContenedorDeVistas contenedor = new MiContenedorDeVistas(vista);
        Log.d("Contenedor", "Creando contenedor de vistas: ");
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiContenedorDeVistas holder, int position) {
        Pedido c = lista_pedidos.get(position);
        holder.tv_titulo.setText(c.getTitulo());
        holder.tv_descripcion.setText(c.getDescripcion());
        holder.imagen.setImageDrawable(c.getFoto());


        Log.d("Contenedor", "Vinculado la posicion" + position);
    }

    @Override
    public int getItemCount() {
        return lista_pedidos.size();
    }

    public static class MiContenedorDeVistas extends RecyclerView.ViewHolder{
        public TextView tv_titulo, tv_descripcion;
        ImageView imagen;

        public MiContenedorDeVistas(View vista) {
            super(vista);
            this.tv_titulo = vista.findViewById(R.id.product_title);
            this.tv_descripcion = vista.findViewById(R.id.product_description);
            this.imagen = vista.findViewById(R.id.imagen_producto);

        }

    }




}