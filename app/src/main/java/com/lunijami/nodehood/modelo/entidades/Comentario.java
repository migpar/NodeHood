package com.lunijami.nodehood.modelo.entidades;

import java.util.Date;

public class Comentario {

    private int origenID, destinoID;
    private Date fecha;
    private String texto;


    public Comentario(int origenID, int destinoID, Date fecha, String texto) {
        this.origenID = origenID;
        this.destinoID = destinoID;
        this.fecha = fecha;
        this.texto = texto;
    }

    public Comentario() {
        super();
    }

    public int getOrigenID() {
        return origenID;
    }

    public void setOrigenID(int origenID) {
        this.origenID = origenID;
    }

    public int getDestinoID() {
        return destinoID;
    }

    public void setDestinoID(int destinoID) {
        this.destinoID = destinoID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
