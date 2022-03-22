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

    //Otros metodos

    /*
     *Seleccionamos un usuario con el metodo buscarUsuarioNIF y el libro con el metodo buscarLiboIsbn
     * si el usuario no tiene mas de 3 libros reservados y el libro esta disponible
     * se añadira esta informacion a la lista de reservas
     */
    public static void hacerReserva(ArrayList<Reserva> listaReserva, ArrayList<Usuario> listaUsuarios, ArrayList<Libro> listaLibros){
        Scanner teclado = new Scanner(System.in);
        Reserva reserva = new Reserva();
        int Reusuario = Usuario.buscarUsuarioNIF(listaUsuarios);

        if(Reusuario>-1){
            int cantidadReservas = 0;
            for (int i = 0; i < listaReserva.size(); i++) {
                if(listaReserva.get(i).getUsuario().getNif().equals(listaUsuarios.get(Reusuario).getNif())){
                    cantidadReservas++;
                }
            }
            if(cantidadReservas<=5){
                reserva.setUsuario(listaUsuarios.get(Reusuario));
                int Relibro = Libro.buscarLibroIsbn(listaLibros);
                if(Relibro>-1){
                    if(listaLibros.get(Relibro).getnCopiasDisponibles()>0){
                        reserva.setLibro(listaLibros.get(Relibro));
                        reserva.setEstado(Estado.Vigente);
                        listaReserva.add(reserva);
                        listaLibros.get(Relibro).setnCopiasDisponibles(listaLibros.get(Relibro).getnCopiasDisponibles()-1);
                        System.out.println("Reserva realizada correctamente");
                    }else{
                        System.out.println("El libro no tiene copias disponibles");
                    }
                }else{
                    System.out.println("Reserva no realizada. El usuario tiene el número máximo de reservas posibles");
                }
            }
        }

    }
    /*
    *Este metodo sirve para devolver libros, es decir, eliminar una reserva de la lista de reservas
    */
    public static void eliminarReserva(ArrayList<Reserva> listaReserva){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el NIF del usuario: ");
        String nif = teclado.nextLine();
        System.out.println("Introduce el ISBN del libro");
        String isbn = teclado.nextLine();
        int i = 0;
        boolean encontrado = false;
        while(!encontrado && i<listaReserva.size()){
            if(listaReserva.get(i).getUsuario().getNif().equals(nif) && listaReserva.get(i).getLibro().getIsbn().equals(isbn)){
                encontrado = true;
                System.out.println("Reserva eliminada");
                listaReserva.get(i).getLibro().setnCopiasDisponibles(listaReserva.get(i).getLibro().getnCopiasDisponibles()+1);
                listaReserva.remove(i);
            }
        }
        if(!encontrado){
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }
    /*
     * Metodo que devuelve un boolean segun si el libro tiene reserva
     */
    public static boolean libroTieneReserva(ArrayList<Reserva> listaReserva, Libro libro){
        boolean reserva = false;
        int i = 0;
        while(!reserva && i<listaReserva.size()){
            if(listaReserva.get(i).getLibro().getIsbn().equals(libro.getIsbn())){
                reserva = true;
            }
            i++;
        }
        return reserva;
    }
}



