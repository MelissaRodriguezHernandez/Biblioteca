package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Libro {
    /*Atributos*/
    private String isbn ;
    private String titulo;
    private String autor;
    private String editorial;
    private int nCopias;
    private int nCopiasDisponibles;
    private static int contadorLibros = 0;

    /*Constructor completo*/
    public Libro(String isbn, String titulo, String autor, String editorial, int nCopias, int nCopiasDisponibles) {
        /*Instancializar los objetos*/
        this.isbn = new String();
        this.titulo = new String();
        this.autor = new String();
        this.editorial = new String();

        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setnCopias(nCopias);
        this.setnCopiasDisponibles(nCopiasDisponibles);

        /*Añadimos +1 al contador de libros*/
        contadorLibros++;
    }

    /*Constructor vacío*/
    public Libro() {
        /*Hacemos uso del contructor completo creado (polimorfismo)*/
        this(null, null, null, null, 0, 0);

    }

    /*Constructor copia*/
    public Libro(Libro libro) {
        /*Hacemos uso del contructor completo creado (polimorfismo)*/
        this(libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getnCopias(), libro.getnCopiasDisponibles());
    }

    /*Metodo toString*/
    @Override
    public String toString() {
        return "Libro{" +
                "Isbn= " + isbn +
                ", Titulo= " + titulo +
                ", Autor= " + autor +
                ", Editorial= " + editorial +
                ", nCopias= " + nCopias +
                ", nCopiasDisponibles= " + nCopiasDisponibles +
                "}";
    }

    /*Getters y Setters*/
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String auto) {
        this.autor = auto;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getnCopias() {
        return nCopias;
    }

    public void setnCopias(int nCopias) {
        this.nCopias = nCopias;
    }

    public int getnCopiasDisponibles() {
        return nCopiasDisponibles;
    }

    public void setnCopiasDisponibles(int nCopiasDisponibles) {
        this.nCopiasDisponibles = nCopiasDisponibles;
    }

    public static int getContadorLibros() {
        return contadorLibros;
    }

    public static void setContadorLibros(int contadorLibros) {
        Libro.contadorLibros = contadorLibros;
    }

    /*Otros Metodos*/
    /*Solicitará los datos para crear un libro y
     *añadirá dicho libro a una lista de libros que recibirá como parámetro el método.
     * (método static)
     */
    public static void añadirLibro(ArrayList<Libro> listaLibros) {
        Scanner teclado = new Scanner(System.in);
        Libro libro = new Libro();
        System.out.println("Introduce el isbn: ");
        libro.setIsbn(teclado.nextLine());
        System.out.println("Introduce el título: ");
        libro.setTitulo(teclado.nextLine());
        System.out.println("Introduce el autor: ");
        libro.setAutor(teclado.nextLine());
        System.out.println("Introduce la editorial: ");
        libro.setEditorial(teclado.nextLine());
        System.out.println("Introduce el número de copias: ");
        /*Utilizamos el metodo parseInt de la clase Integer para poder usar el nextLine y que el buffer no guarde el intro*/
        libro.setnCopias(Integer.parseInt(teclado.nextLine()));
        System.out.println("Introduce el número de copias disponibles: ");
        libro.setnCopiasDisponibles(Integer.parseInt(teclado.nextLine()));

        /*Añadimos el objeto libro al Arraylist que pasamos por parametro*/
        listaLibros.add(libro);

        contadorLibros++;
    }

    /*Pedirá al usuario un ISBN, lo buscará en la lista que recibirá como parámetro el método.
     *En caso de encontrarlo devolverá la posición en la que se encuentra,
     * en caso contrario devolverá -1.
     * (método static)
     */
    public static int buscarLibroIsbn(ArrayList<Libro> listaLibros) {
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        System.out.println("Introduce el isbn del libro: ");
        texto = teclado.nextLine();
        boolean encontrado = false;
        int i = 0;
        int posición = -1;
        while (!encontrado && i < listaLibros.size()) {
            if (texto.equals(listaLibros.get(i).getIsbn())) {
                encontrado = true;
                posición = i;
            }
            i++;
            if (encontrado) {
                System.out.println("Se ha encontrado el libro en la posición: " + posición);
                System.out.println(listaLibros.get(posición).toString());
            } else {
                System.out.println("No se ha encontrado ningun libro con el isbn introducido");
            }
        }
        System.out.println("");
        return posición;
    }

    /*Solicitará al usuario un ISBN, lo buscará y
     *lo eliminará de la lista que recibirá como parámetro el método.
     *No se puede eliminar un libro que tiene reservas.
     * (método static)
     */
    public static void eliminarLibro(ArrayList<Libro> listaLibros, ArrayList<Reserva> listaReserva) {
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        int posición = buscarLibroIsbn(listaLibros);

        if(posición>=0) {
            boolean reserva = Reserva.libroTieneReserva(listaReserva, listaLibros.get(posición));
            if(!reserva){
                System.out.println("¿Seguro que deseas eliminar el libro?(s/n)");
                String respuesta = teclado.nextLine();
                if(respuesta.equals("s")){
                    listaLibros.remove(posición);
                    System.out.println("El libro ha sido eliminado correctamente");
                    contadorLibros--;
                }
            }else{
                System.out.println("El libro no se ha podido eliminar porque tiene al menos una reserva");
            }
        }
        System.out.println("");
    }

    /*Pedirá al usuario un título, lo buscará en la lista que recibirá como parámetro el método.
     *Mostrará cualquier libro que contenga la cadena buscada.
     * (método static)
     */
    public static void buscarLibroTitulo(ArrayList<Libro> listaLibros) {
        Scanner teclado = new Scanner(System.in);
        String texto = new String();
        System.out.println("Introduce el titulo del libro o alguna palabra clave: ");
        texto = teclado.nextLine();
        boolean encontrado = false;
        int posicion = -1;
        for (int i = 0; i < listaLibros.size(); i++) {
            if(listaLibros.get(i).getTitulo().contains(texto)){
                encontrado = true;
                System.out.println(listaLibros.get(i).toString());
            }
        }
        if(!encontrado){
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
        System.out.println("");
    }

    public static int mostrarCantidadLibros(ArrayList<Libro> listaLibros){
        int cantidad = listaLibros.size();
        System.out.println("La Biblioteca tiene "+cantidad+" libros");
        System.out.println("");
        return cantidad;

    }
}
