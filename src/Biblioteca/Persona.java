package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
    /*Atributos*/
    private String nombre ;
    private String apellidos ;
    private String nif ;
    private String contraseña ;

    /*Constructor completo*/
    public Persona(String nombre, String apellidos, String nif, String contraseña) {
       this.nombre = new String();
       this.apellidos  = new String();
       this.nif = new String();
       this.contraseña = new String();

       this.setNombre(nombre);
       this.setApellidos(apellidos);
       this.setNif(nif);
       this.setContraseña(contraseña);

    }
    /*Constructor vacío*/
    public Persona() {
        this(null, null, null, null);
    }

    /*Construcor copia*/
    public Persona(Persona persona){
        this(persona.getNombre(), persona.getApellidos(), persona.getNif(), persona.getContraseña()  );
    }

    /*Metodo toString*/
    @Override
    public String toString() {
        return "Persona{" +
                " Nombre = " + nombre +
                ", Apellidos = " + apellidos +
                ", NIF = " + nif +
                ", Contraseña = " + contraseña +
                "}";
    }
    /*Getters y Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
        /*Ponemos un controlador en la contraseña para que siempre sea mayor de 8 caracteres*/
        Scanner teclado = new Scanner(System.in);
        while(contraseña.length()<8){
            System.out.println("Introduce la contraseña, debe tener minimo 8 caracteres: ");
            contraseña = teclado.nextLine();
        }
        this.contraseña = contraseña;
    }

    /*Otros metodos*/

    /*Solicitará los datos para crear un objeto persona
     *y añadirá dicha persona a una lista de personas que recibirá como parámetro el método.
     *(método static)
     */
    public static void añadirPersona(ArrayList<Persona> listaPersonal){
        Scanner teclado = new Scanner(System.in);
        Persona persona = new Persona();
        System.out.println("Introduce el nombre: ");
        persona.setNombre(teclado.nextLine());
        System.out.println("Introduce los apellidos: ");
        persona.setApellidos(teclado.nextLine());
        System.out.println("Introduce el NIF: ");
        persona.setNif(teclado.nextLine());
        listaPersonal.add(persona);
        System.out.println("");
    }

    /*Solicitará al usuario un nif, lo buscará y
     *lo eliminará de la lista que recibirá como parámetro el método.
     *(método static)
     */
    public static void eliminarPersona(ArrayList<Persona> listaPersonal){
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        System.out.println("Introduce el nif de la persona: ");
        texto = teclado.nextLine();
        boolean encontrado = false;
        int i = 0;
        int posicion = -1;
        while( i<listaPersonal.size()){
            if(texto.equals(listaPersonal.get(i).getNif())){
                encontrado = true;
                posicion = i;
                listaPersonal.remove(i);
            }
            i++;

            if(encontrado){
                System.out.println("La persona que se ha eliminado estaba en la posición: "+posicion);
            }else{
                System.out.println("No se ha encontrado ninguna coincidencia");
            }
        }
        System.out.println("");
    }
    /*Solicitará  un nif por consola y
     *buscara en la lista de personas que pasaremos por parametro
     * devolviendo toda la información (en el caso de encontrar coincidencia)
     */
    public static void buscarPersonaNIF(ArrayList<Persona> listaPersonal){
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        System.out.println("Introduce el NIF de la persona: ");
        texto = teclado.nextLine();
        boolean encontrado = false;
        int posicion = -1;
        for (int i = 0; i < listaPersonal.size(); i++) {
            if(listaPersonal.get(i).getNif().contains(texto)){
                encontrado = true;
                System.out.println(listaPersonal.get(i).toString());
            }
        }
        if(!encontrado){
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
        System.out.println("");
    }
}
