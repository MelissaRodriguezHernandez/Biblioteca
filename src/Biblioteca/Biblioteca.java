package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    /*Atributos*/
    private String nombre ;
    private ArrayList<Libro>  listaLibros ;
    private ArrayList<Persona> listaPersonal ;
    private ArrayList<Usuario> listaUsuarios;

    /*Constructor completo*/
    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal, ArrayList<Usuario> listaUsuarios) {
        this.nombre = new String();
        this.listaLibros = new ArrayList();
        this.listaPersonal = new ArrayList();
        this.listaUsuarios = new ArrayList();

        this.setNombre(nombre);
        this.setListaLibros(listaLibros);
        this.setListaPersonal(listaPersonal);
        this.setListaUsuarios(listaUsuarios);
    }
    /*Constructor vacio*/
    public Biblioteca(){
        this(null, null, null, null);
    }
    /*Constructor copia*/
    public Biblioteca(Biblioteca biblioteca){
        this(biblioteca.getNombre(), biblioteca.getListaLibros(), biblioteca.getListaPersonal(), biblioteca.getListaUsuarios());
    }

    /*Metodo toString*/
    @Override
    public String toString() {
        return "Biblioteca{" +
                " Nombre='" + nombre +
                ", Lista de Libros= " + listaLibros +
                ", Lista del Personal= " + listaPersonal +
                ", Lista de Usuarios= "+ listaUsuarios+
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
    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }
    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /*Otros Metodos*/

    /*Mostrar libros.
     *Imprimirá por pantalla toda la lista de libros.
     */
    public static void mostrarLibros(ArrayList<Libro> listaLibros){
        for (int i = 0; i <= listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i).toString());
            System.out.println("");
        }
    }

    /*Mostrar libros disponibles.
     *Solo imprime la lista de los libros disponibles.
     */
    public static void mostrarLibrosDisponibles(ArrayList<Libro> listaLibros){
        for (int i = 0; i <= listaLibros.size(); i++) {
            if (listaLibros.get(i).getnCopiasDisponibles()>0){
                System.out.println(listaLibros.get(i).toString());
            }
        }
        System.out.println("");
    }

    /*Imprimirá por pantalla toda la lista de personas
     *
     */
    public static void mostrarPersonal(ArrayList<Persona> listaPersonal){
        for (int i = 0; i <= listaPersonal.size(); i++) {
            System.out.println(listaPersonal.get(i).toString());
            System.out.println("");
        }
    }

    /*Imprimirá por pantalla toda la lista de usuarios.
     *
     */
    public static void mostrarUsuarios(ArrayList<Usuario> listaUsuarios){
        for (int i = 0; i <= listaUsuarios.size(); i++) {
            System.out.println(listaUsuarios.get(i).toString());
            System.out.println("");
        }
    }

    /*Main donde se concentra
     *el codigo en menus con switches para interactuar
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Libro>  listaLibros = new ArrayList();
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
            System.out.println("1. || Gestión de Personal ||{Añadir persona, Eliminar persona, Buscar persona por NIF, Ver listado del personal}");
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
                        Persona.añadirPersona(listaPersonal);
                        break;
                    case 2:
                        Persona.eliminarPersona(listaPersonal);
                        break;
                    case 3:
                        Persona.buscarPersonaNIF(listaPersonal);
                        break;
                    case 4:
                        mostrarPersonal(listaPersonal);
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
                        Usuario.añadirUsuario(listaUsuarios);
                        break;
                    case 2:
                        Usuario.eliminarUsuario(listaUsuarios);
                        break;
                    case 3:
                        Usuario.buscarUsuarioNIF(listaUsuarios);
                        break;
                    case 4:
                        mostrarUsuarios(listaUsuarios);;
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
                            Reserva.hacerReserva(listaReserva, listaUsuarios, listaLibros);
                        break;
                    case 2:
                            Reserva.eliminarReserva(listaReserva);
                        break;
                    case 3:
                            mostrarLibrosDisponibles(listaLibros);
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
                        Libro.añadirLibro(listaLibros);
                        break;
                    case 2:
                        Libro.eliminarLibro(listaLibros, listaReserva);
                        break;
                    case 3:
                        Libro.buscarLibroIsbn(listaLibros);
                        break;
                    case 4:
                        Libro.buscarLibroTitulo(listaLibros);
                    case 5:
                        mostrarLibros(listaLibros);
                        break;
                    case 6:
                        Libro.mostrarCantidadLibros(listaLibros);
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
