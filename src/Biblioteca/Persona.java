package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Persona {
    /*Atributos*/
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer edad;

    /*Constructores*/

    /*Constructor completo*/
    public Persona(String nombre, String apellido1, String apellido2, Integer edad) {
       this.nombre = new String();
       this.apellido1 = new String();
       this.apellido2 = new String();

       this.setNombre(nombre);
       this.setApellido1(apellido1);
       this.setApellido2(apellido2);
       this.setEdad(edad);
    }

    /*Constructor vacio*/
    public Persona(){
        this(null, null, null, null);}

    /*Constructor copia*/
    public Persona(Persona persona){
        this(persona.getNombre(), persona.getApellido1(), persona.getApellido2(), persona.getEdad());
    }


    /*Getters y Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    /*Metodo toString*/

    @Override
    public String toString() {
        return "Personas{" +
                " Nombre= " + nombre +
                ", Apellido1= " + apellido1 +
                ", Apellido2= " + apellido2 +
                ", Edad= " + edad +
                "}";
    }


    /*Otros metodos*/
    public void solicitarDatosPersona(ArrayList<Persona> listaPersonas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre:");
        this.setNombre(teclado.nextLine());
        System.out.println("Introduce el primer apellido: ");
        this.setApellido1(teclado.nextLine());
        System.out.println("Introduce el segundo apellido: ");
        this.setApellido2(teclado.nextLine());
        System.out.println("Introduce la edad: ");
        this.setEdad(teclado.nextInt());

    }
}
