package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecario extends Persona {
    /*Atributos*/
    private String puestoTrabajo;
    private String nif;
    private String contraseña;

    /*Constructores*/

    /*Constructor completo*/

    public Bibliotecario(String nombre, String apellido1, String apellido2, Integer edad, String puestoTrabajo, String nif, String contraseña) {
        super(nombre, apellido1, apellido2, edad);

        this.puestoTrabajo = new String();
        this.nif = new String();
        this.contraseña = new String();

        this.setPuestoTrabajo(puestoTrabajo);
        this.setNif(nif);
        this.setContraseña(contraseña);
    }

    /*Constructor vacio*/
    public Bibliotecario(){
        this(null, null, null, null, null, null, null);
    }

    /*Constructor copia*/
    public Bibliotecario(Bibliotecario bibliotecario){
        this(bibliotecario.getNombre(), bibliotecario.getApellido1(), bibliotecario.getApellido2(), bibliotecario.getEdad(), bibliotecario.getPuestoTrabajo(), bibliotecario.getNif(), bibliotecario.getContraseña());
    }

    /*Getters y Setters*/
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /*Metodo toString*/
    @Override
    public String toString() {
        return "Bibliotecario{" +
                " Nombre= " + getNombre() + "\n" +
                ", Apellido1= " + getApellido1() + "\n" +
                ", Apellido2= " + getApellido2() + "\n" +
                ", Edad= " + getEdad() + "\n" +
                " PuestoTrabajo= " + puestoTrabajo + "\n" +
                ", NIF= " + nif +"\n" +
                ", Contraseña= " + contraseña + "\n" +
                "}";
    }
    /*Otros metodos*/
    @Override
    public void solicitarDatosPersona(ArrayList<Persona> listaPersonas){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre: ");
        super.setNombre(teclado.nextLine());
        System.out.println("Introduce el primer apellido: ");
        super.setApellido1(teclado.nextLine());
        System.out.println("Introduce el segundo apellido: ");
        super.setApellido2(teclado.nextLine());
        System.out.println("Introduce la edad: ");
        super.setEdad(teclado.nextInt());
        System.out.println("Introduce el puesto de trabajo: ");
        this.setPuestoTrabajo(teclado.nextLine());
        System.out.println("Introduce el NIF: ");
        this.setNif(teclado.nextLine());
        System.out.println("Introduce la contraseña: ");
        this.setContraseña(teclado.nextLine());
    }
}


