package com.lunijami.nodehood.modelo.entidades;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * @author Miguel Parra
 */
public class Pedido {

    private int id;
    private int emisorID, receptorID;
    private String titulo, descripcion;
    private Drawable foto;//cambiar por uri cuando se implemente


    public Pedido(String titulo, String descripcion, Drawable foto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }
}
