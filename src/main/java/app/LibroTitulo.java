package app;

import java.util.ArrayList;

public class LibroTitulo {
    private String nombre;
    private Autor autor;
    private ArrayList<LibroCopia> copias = new ArrayList<>();

    public LibroTitulo(String nombre, Autor autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public void agregarCopia(LibroCopia copia) {
        copias.add(copia);
    }

    public String getNombre() {
        return nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public ArrayList<LibroCopia> getCopias() {
        return copias;
    }
}
