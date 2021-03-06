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
         *para poder dar la opci??n de continuar si lo decisimos
         */
        boolean salir = true;
        while(salir){
            /*Men?? principal con las redirecciones a los peque??os men??s de gestiones*/
            int opcionMenu;
            System.out.println("Elije un men??: ");
            System.out.println("1. || Gesti??n de Personal ||{A??adir bibliotecario, Eliminar bibliotecario, Buscar bibliotecario por NIF, Ver listado del personal}");
            System.out.println("2. || Gesti??n de Usuarios ||{A??adir usuario, Eliminar Usuario, Buscar usuario por NIF, Ver listado de usuarios}");
            System.out.println("3. || Gesti??n de Reservas ||{Reservar un libro, Devolver un Libro, Ver lista de libros Disponibles}");
            System.out.println("4. || Gesti??n de Libros ||{A??adir Libro, Eliminar Libro, Buscar libro por isbn, Buscar libro por t??tulo, Ver lista de Libros, Ver cantidad de libros}");
            opcionMenu = teclado.nextInt();

            if(opcionMenu==1){
                int opci??nM1;
                /*Menu para gestionar el personal de la biblioteca*/
                System.out.println("|| Menu de gesti??n de personal ||");
                System.out.println("Elije una opci??n: ");
                System.out.println("1. A??adir persona");
                System.out.println("2. Eliminar persona");
                System.out.println("3. Buscar persona por NIF");
                System.out.println("4. Ver listado del personal");
                opci??nM1 = teclado.nextInt();
                switch (opci??nM1){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                    default:
                        /*Si la persona introduce un opci??n no valida dara un mensaje de advertencia
                         *y se ira directamente a la opci??n de continuar
                         */
                        System.out.println("Esa opci??n no es v??lida");
                }
            }
            if(opcionMenu==2){
                /*Menu para la gesti??n de usuarios(lectores)*/
                int opci??nM2;
                System.out.println("||Men?? de gesti??n de Usuarios ||");
                System.out.println("1. A??adir Usuario");
                System.out.println("2. Eliminar Usuario");
                System.out.println("3. Buscar usuario por NIF");
                System.out.println("4. Ver listado de Usuarios");
                opci??nM2 = teclado.nextInt();
                switch (opci??nM2) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        /*Si la persona introduce un opci??n no v??lida dara un mensaje de advertencia
                         *y se ira directamente a la opci??n de continuar
                         */
                        System.out.println("Esa opci??n no es v??lida");
                }
            }
            if(opcionMenu==3){
                /*Men?? para la gesti??n de reservas que haran los usuarios*/
                int opci??nM3;
                System.out.println("|| Men?? de gesti??n de reservas ||");
                System.out.println("1. Reservar un libro");
                System.out.println("2. Devolver un libro");
                System.out.println("3. Ver listado de libros disponibles");
                opci??nM3 = teclado.nextInt();
                switch (opci??nM3){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        /*Si la persona introduce un opci??n no v??lida dara un mensaje de advertencia
                         *y se ira directamente a la opci??n de continuar
                         */
                        System.out.println("Esa opci??n no es v??lida");
                }
            }
            if(opcionMenu==4){
                /*Menu para la gesti??n de libros que tendra la biblioteca y que interatuaran los usuarios*/
                int opci??nM4;
                System.out.println("|| Men?? de gesti??n de libros ||");
                System.out.println("1. A??adir un libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Buscar libro por isbn");
                System.out.println("4. Buscar libro por t??tulo");
                System.out.println("5. Ver listado de libros");
                System.out.println("6. Ver cantidad de libros");
                opci??nM4 = teclado.nextInt();
                switch (opci??nM4){
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
                        /*Si la persona introduce un opci??n no v??lida dara un mensaje de advertencia
                         *y se ira directamente a la opci??n de continuar
                         */
                        System.out.println("Esa opci??n no es v??lida");
                }
            }
            /*Peque??o menu para poder continuar si se desea*/
            int opci??nContinuar;
            System.out.println("??Quieres continuar?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opci??nContinuar = teclado.nextInt();
            switch (opci??nContinuar){
                case 1:
                    salir = true;
                    break;
                case 2:
                    salir = false;
                    break;
                default:
                    /*Opci??n por defecto si no se elige ninguna opci??n dada
                     *emitira un mensaje de error si no se elige una opci??n o se introduc un n??mero aleatorio
                     *y automaticamente saldra del bucle terminando asi la sesi??n y la ejecuci??n del programa
                     */
                    System.out.println("Esa opci??n no es v??lida, se da por hecho que quieres salir");
                    salir = false;
            }
            System.out.println("");
        }
    }
}
