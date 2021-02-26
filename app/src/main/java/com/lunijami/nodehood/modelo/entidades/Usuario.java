package com.lunijami.nodehood.modelo.entidades;

import java.util.List;

/**
 * @author Miguel Parra
 */
public class Usuario {


    private String nombre, email, telefono, contraseña;
    List<Integer> listaPedidosID; //Le introducimos solo el id de los pedidos

    public Usuario(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono="no number";
    }

    public Usuario() {
        super();
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

    public List<Integer> getListaPedidosID() {
        return listaPedidosID;
    }

    public void setListaPedidosID(List<Integer> listaPedidosID) {
        this.listaPedidosID = listaPedidosID;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void añadirPedido(int pedidoID) {
        listaPedidosID.add(pedidoID);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", listaPedidosID=" + listaPedidosID +
                '}';
    }
}
