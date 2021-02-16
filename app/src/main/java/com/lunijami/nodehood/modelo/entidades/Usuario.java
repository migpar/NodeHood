package com.lunijami.nodehood.modelo.entidades;

import java.util.List;

/**
 * @author Miguel Parra
 */
public class Usuario {

    private int id;
    private String nombre, email, telefono, direccion;
    List<Integer> listaPedidosID; //Le introducimos solo el id de los pedidos

    public Usuario(String nombre, String email, String telefono, String direccion, List<Integer> listaPedidosID) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaPedidosID = listaPedidosID;
    }

    public Usuario() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Integer> getListaPedidosID() {
        return listaPedidosID;
    }

    public void setListaPedidosID(List<Integer> listaPedidosID) {
        this.listaPedidosID = listaPedidosID;
    }

    public void añadirPedido(int pedidoID) {
        listaPedidosID.add(pedidoID);
    }
}
