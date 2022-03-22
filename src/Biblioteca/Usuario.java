package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    //Atributos
    private String nombre = new String();
    private String apellidos = new String();
    private String nif = new String();
    private String contraseña = new String();

    //Constructor completo
    public Usuario(String nombre, String apellidos, String nif, String contraseña) {
        //Instancializamos
        nombre = new String();
        apellidos = new String();
        nif = new String();
        contraseña = new String();

        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setNif(nif);
        this.setContraseña(contraseña);
    }
    //Construcor copia
    public Usuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getApellidos(), usuario.getNif(), usuario.getContraseña());
    }
    //Constructor vacío
    public Usuario() {
        this(null, null, null, null);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "usuario{" +
                " Nombre= " + nombre +
                ", Apellidos= " + apellidos +
                ", NIF= " + nif +
                ", Contraseña= " + contraseña +
                "}";
    }

    //Getters y Setters
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
        this.contraseña = contraseña;}

    //Otros metodos

    /*Solicitará los datos para crear un objeto usuario
     *y añadirá dicha usuario a una lista de usuarios que recibirá como parámetro el método.
     *(método static)
     */
    public static void añadirUsuario(ArrayList<Usuario> listaUsuario){
        Scanner teclado = new Scanner(System.in);
        Usuario usuario = new Usuario();
        System.out.println("Introduce el nombre: ");
        usuario.setNombre(teclado.nextLine());
        System.out.println("Introduce los apellidos: ");
        usuario.setApellidos(teclado.nextLine());
        System.out.println("Introduce el NIF: ");
        usuario.setNif(teclado.nextLine());
        listaUsuario.add(usuario);
        System.out.println("");
    }

    /*Solicitará  un nif, lo buscará y
     *lo eliminará de la lista que recibirá como parámetro el método.
     *(método static)
     */
    public static void eliminarUsuario(ArrayList<Usuario> listaUsuario){
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        System.out.println("Introduce el nif del usuario ");
        texto = teclado.nextLine();
        boolean encontrado = false;
        int i = 0;
        int posicion = -1;
        while( i<listaUsuario.size()){
            if(texto.equals(listaUsuario.get(i).getNif())){
                encontrado = true;
                posicion = i;
                listaUsuario.remove(i);
            }
            i++;

            if(encontrado){
                System.out.println("El usuario que se ha eliminado estaba en la posición: "+posicion);
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
    public static int buscarUsuarioNIF(ArrayList<Usuario> listaUsuarios){
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        System.out.println("Introduce el NIF de la usuario: ");
        texto = teclado.nextLine();
        boolean encontrado = false;
        int posicion = -1;
        int i = 0;
        while(!encontrado && i<listaUsuarios.size()){
            if(listaUsuarios.get(i).getNif().equals(texto)){
                encontrado = true;
                System.out.println("Información del usuario: ");
                System.out.println(listaUsuarios.get(i).toString());
                posicion = i;
            }
            i++;
        }
        if(!encontrado){
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
        System.out.println("");
        return posicion;
    }
}
