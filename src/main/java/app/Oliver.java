package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Oliver {
    private static Oliver oliver;
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<LibroTitulo> libros = new ArrayList<>();

    private Oliver() {
    }

    public static Oliver getInstance() {
        if (oliver == null) {
            return new Oliver();
        }
        return oliver;
    }

    private LibroTitulo buscarLibro(String nombre, Autor autor) {
        for (LibroTitulo libro : libros) {
            if (Objects.equals(libro.getNombre(), nombre) && Objects.equals(
                libro.getAutor().getNombre(), autor.getNombre())) {
                return libro;
            }
        }
        return null;
    }

    public LibroCopia registrarLibro(String nombre, String anho, Autor autor, String edicion) {
        LibroTitulo libro = this.buscarLibro(nombre, autor);
        if (libro == null) {
            libro = new LibroTitulo(nombre, autor);
            libros.add(libro);
        }

        LibroCopia copia = new LibroCopia(libro, anho, edicion);
        libro.agregarCopia(copia);
        return copia;
    }

    public List<LibroCopia> buscarLibrosPorAuthor(Autor autor) {
        ArrayList<LibroCopia> librosPorAuthor = new ArrayList<>();
        for (LibroTitulo libro : libros) {
            if (Objects.equals(libro.getAutor().getNombre(), autor.getNombre())) {
                for (LibroCopia copia : libro.getCopias()) {
                    librosPorAuthor.add(copia);
                }
            }
        }
        return librosPorAuthor;
    }

    public LibroCopia buscarLibroPorEdicion(LibroTitulo libro, String edicion) {
        for (LibroTitulo l: libros) {
            if (l == libro) {
                for (LibroCopia copia: l.getCopias()) {
                    if (copia.getEdicion() == edicion) {
                        return copia;
                    }
                }
            }
        }
        return null;
    }

    public List<LibroCopia> getLibros() {
        List<LibroCopia> copias = new ArrayList<>();
        for (LibroTitulo libro : libros) {
            for (LibroCopia copia : libro.getCopias()) {
                copias.add(copia);
            }
        }
        return copias;
    }

    public Estudiante registrarEstudiante(String nombre, String email, String celular) {
        Estudiante estudiante = new Estudiante(nombre, email, celular);
        return estudiante;
    }
}
