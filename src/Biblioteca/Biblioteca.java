package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    /*Atributos*/
    private String nombre ;
    private ArrayList<Libro>  listaLibros ;
    private ArrayList<Persona> listaPersonas ;


    /*Constructor completo*/
    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas) {
        this.nombre = new String();
        this.listaLibros = new ArrayList();
        this.listaPersonas = new ArrayList();

        this.setNombre(nombre);
        this.setListaLibros(listaLibros);
        this.setListaPersonas(listaPersonas);
    }
    /*Constructor vacio*/
    public Biblioteca(){
        this(null, null, null);
    }
    /*Constructor copia*/
    public Biblioteca(Biblioteca biblioteca){
        this(biblioteca.getNombre(), biblioteca.getListaLibros(), biblioteca.getListaPersonas());
    }

    /*Metodo toString*/
    @Override
    public String toString() {
        return "Biblioteca{" +
                " Nombre='" + nombre +
                ", Lista de Libros= " + listaLibros +
                ", Lista del Personal= " + listaPersonas +
                "}";
    }

    /*Getters y Setters*/
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        /*Controlador para que la primera letra del nombre sea en mayusculas*/
        Scanner teclado = new Scanner(System.in);
        while(Character.isLowerCase(nombre.charAt(0))){
            System.out.println("Introduce un nombre con la primera letra en mayusuclas: ");
            nombre = teclado.nextLine();
        }
        this.nombre = nombre;
    }
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
    public void setListaPersonas(ArrayList<Persona> listaPersonal) {
        this.listaPersonas = listaPersonal;
    }

    /*Otros Metodos*/
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Libro> listaLibros = new ArrayList();
        ArrayList<Persona> listaPersonal = new ArrayList();
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        ArrayList<Reserva> listaReserva = new ArrayList();

        /*Hacer una variable de tipo booleana
         *para poder dar la opción de continuar si lo decisimos
         */
        boolean salir = true;
        while(salir){
            /*Menú principal con las redirecciones a los pequeños menús de gestiones*/
            int opcionMenu;
            System.out.println("Elije un menú: ");
            System.out.println("1. || Gestión de Personal ||{Añadir bibliotecario, Eliminar bibliotecario, Buscar bibliotecario por NIF, Ver listado del personal}");
            System.out.println("2. || Gestión de Usuarios ||{Añadir usuario, Eliminar Usuario, Buscar usuario por NIF, Ver listado de usuarios}");
            System.out.println("3. || Gestión de Reservas ||{Reservar un libro, Devolver un Libro, Ver lista de libros Disponibles}");
            System.out.println("4. || Gestión de Libros ||{Añadir Libro, Eliminar Libro, Buscar libro por isbn, Buscar libro por título, Ver lista de Libros, Ver cantidad de libros}");
            opcionMenu = teclado.nextInt();

            if(opcionMenu==1){
                int opciónM1;
                /*Menu para gestionar el personal de la biblioteca*/
                System.out.println("|| Menu de gestión de personal ||");
                System.out.println("Elije una opción: ");
                System.out.println("1. Añadir persona");
                System.out.println("2. Eliminar persona");
                System.out.println("3. Buscar persona por NIF");
                System.out.println("4. Ver listado del personal");
                opciónM1 = teclado.nextInt();
                switch (opciónM1){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                    default:
                        /*Si la persona introduce un opción no valida dara un mensaje de advertencia
                         *y se ira directamente a la opción de continuar
                         */
                        System.out.println("Esa opción no es válida");
                }
            }
            if(opcionMenu==2){
                /*Menu para la gestión de usuarios(lectores)*/
                int opciónM2;
                System.out.println("||Menú de gestión de Usuarios ||");
                System.out.println("1. Añadir Usuario");
                System.out.println("2. Eliminar Usuario");
                System.out.println("3. Buscar usuario por NIF");
                System.out.println("4. Ver listado de Usuarios");
                opciónM2 = teclado.nextInt();
                switch (opciónM2) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        /*Si la persona introduce un opción no válida dara un mensaje de advertencia
                         *y se ira directamente a la opción de continuar
                         */
                        System.out.println("Esa opción no es válida");
                }
            }
            if(opcionMenu==3){
                /*Menú para la gestión de reservas que haran los usuarios*/
                int opciónM3;
                System.out.println("|| Menú de gestión de reservas ||");
                System.out.println("1. Reservar un libro");
                System.out.println("2. Devolver un libro");
                System.out.println("3. Ver listado de libros disponibles");
                opciónM3 = teclado.nextInt();
                switch (opciónM3){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        /*Si la persona introduce un opción no válida dara un mensaje de advertencia
                         *y se ira directamente a la opción de continuar
                         */
                        System.out.println("Esa opción no es válida");
                }
            }
            if(opcionMenu==4){
                /*Menu para la gestión de libros que tendra la biblioteca y que interatuaran los usuarios*/
                int opciónM4;
                System.out.println("|| Menú de gestión de libros ||");
                System.out.println("1. Añadir un libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Buscar libro por isbn");
                System.out.println("4. Buscar libro por título");
                System.out.println("5. Ver listado de libros");
                System.out.println("6. Ver cantidad de libros");
                opciónM4 = teclado.nextInt();
                switch (opciónM4){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        /*Si la persona introduce un opción no válida dara un mensaje de advertencia
                         *y se ira directamente a la opción de continuar
                         */
                        System.out.println("Esa opción no es válida");
                }
            }
            /*Pequeño menu para poder continuar si se desea*/
            int opciónContinuar;
            System.out.println("¿Quieres continuar?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opciónContinuar = teclado.nextInt();
            switch (opciónContinuar){
                case 1:
                    salir = true;
                    break;
                case 2:
                    salir = false;
                    break;
                default:
                    /*Opción por defecto si no se elige ninguna opción dada
                     *emitira un mensaje de error si no se elige una opción o se introduc un número aleatorio
                     *y automaticamente saldra del bucle terminando asi la sesión y la ejecución del programa
                     */
                    System.out.println("Esa opción no es válida, se da por hecho que quieres salir");
                    salir = false;
            }
            System.out.println("");
        }
    }
}
