package com.lunijami.nodehood.modelo.entidades;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class MisPedidos {

    private String titulo, descripcion;
    private Drawable foto;

    public MisPedidos(String titulo, String descripcion, Drawable foto) {
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
