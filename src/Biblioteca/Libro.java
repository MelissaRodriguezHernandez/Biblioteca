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

}
