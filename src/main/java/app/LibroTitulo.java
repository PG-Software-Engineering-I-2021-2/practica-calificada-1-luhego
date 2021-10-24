package app;

import java.util.ArrayList;

public class LibroTitulo {
    private String nombre;
    private String anho;
    private Autor autor;
    private ArrayList<LibroCopia> copias = new ArrayList<>();

    public LibroTitulo(String nombre, String anho, Autor autor) {
        this.nombre = nombre;
        this.anho = anho;
        this.autor = autor;
    }

    public void agregarCopia(LibroCopia copia) {
        copias.add(copia);
    }
}
