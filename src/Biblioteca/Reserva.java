package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
    /*Atributos*/
    private Usuario usuario;
    private Libro libro;
    private Estado estado;

    /*Constructor completo*/
    public Reserva(Usuario usuario, Libro libro, Estado estado) {
        this.usuario = new Usuario();
        this.libro = new Libro();

        this.setUsuario(usuario);
        this.setLibro(libro);
        this.setEstado(estado);
    }
    /*Constructor vacío*/
    public Reserva(){
        this(null, null, null);
    }

    /*Setters y Getters*/
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /*Metodo toString*/
    @Override
    public String toString() {
        return "Reserva{" +
                "Persona= " + usuario +
                ", Libro= " + libro +
                ", Estado= " + estado +
                "}";
    }

    /*Otros metodos*/


}



