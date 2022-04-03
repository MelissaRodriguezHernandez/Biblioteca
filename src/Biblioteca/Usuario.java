package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Persona {
    /*Atributos*/
    private String telefono;
    private String direccion;
    private String codigoPostal;
    private String correoElectronico;
    private ArrayList<Reserva> listaResevas;

    /*Constructores*/

    /*Constructor completo*/

    public Usuario(String nombre, String apellido1, String apellido2, Integer edad, String telefono, String direccion, String codigoPostal, String correoElectronico, ArrayList<Reserva> listaResevas) {
        super(nombre, apellido1, apellido2, edad);

        this.telefono = new String();
        this.direccion = new String();
        this.codigoPostal = new String();
        this.correoElectronico = new String();
        this.listaResevas = new ArrayList();

        this.setTelefono(telefono);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setCodigoPostal(codigoPostal);
        this.setCorreoElectronico(correoElectronico);
        this.setListaResevas(listaResevas);

    }

    /*Constructor vacio*/
    public Usuario(){
        this(null, null, null, null, null, null, null, null, null);
    }

    /*Getters y Setters*/
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Reserva> getListaResevas() {
        return listaResevas;
    }

    public void setListaResevas(ArrayList<Reserva> listaResevas) {
        this.listaResevas = listaResevas;
    }
    /*Metodo toString*/

    @Override
    public String toString() {
        return "Usuario{" +
                ", Telefono= " + telefono + "\n" +
                ", Direccion= " + direccion + "\n" +
                ", CodigoPostal= " + codigoPostal + "\n" +
                ", CorreoElectronico= " + correoElectronico + "\n" +
                ", ListaResevas= " + listaResevas +
                '}';
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
        System.out.println("Introduce el telefono: ");
        this.setTelefono(teclado.nextLine());
        System.out.println("Introduce la direccion: ");
        this.setDireccion(teclado.nextLine());
        System.out.println("Introduce el codigo postal: ");
        this.setCodigoPostal(teclado.nextLine());
        System.out.println("Introduce el correo electronico: ");
        this.setCorreoElectronico(teclado.nextLine());
    }
}
