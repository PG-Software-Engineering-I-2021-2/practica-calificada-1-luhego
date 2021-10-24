package app;

import java.util.ArrayList;
import java.util.Map;

public class Oliver {
    private static Oliver oliver;
    private Map<String, Estudiante> estudiantes;
    private ArrayList<LibroTitulo> libros = new ArrayList<>();

    private Oliver() {}

    public static Oliver getInstance() {
        if (oliver == null) {
            return new Oliver();
        }
        return oliver;
    }

    public  LibroCopia registrarLibro(String nombre, String anho, Autor autor, String edicion) {
        LibroTitulo libro = new LibroTitulo(nombre, anho, autor);
        LibroCopia copia = new LibroCopia(libro, edicion);
        libro.agregarCopia(copia);
        libros.add(libro);
        return copia;
    }

    public ArrayList<LibroTitulo> buscarLibrosPorAuthor(Autor autor) {
        return new ArrayList<>();
    }

    public ArrayList<LibroTitulo> getLibros() {
        return libros;
    }
}
