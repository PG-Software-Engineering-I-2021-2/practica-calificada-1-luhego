package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Oliver implements Publisher {
    private List<Observer> observers = new ArrayList<>();

    private static Oliver oliver;
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<LibroTitulo> libros = new ArrayList<>();
    private List<Oferta> ofertas = new ArrayList<>();

    private Oliver() {
    }

    public static Oliver getInstance() {
        if (oliver == null) {
            return new Oliver();
        }
        return oliver;
    }

    private LibroTitulo buscarLibro(String nombre, Autor autor) {
        System.out.println("Buscar libro por nombre " + nombre + " y author " + autor.getNombre() + " "
            + autor.getFechaNacimiento());
        for (LibroTitulo libro : libros) {
            if (Objects.equals(libro.getNombre(), nombre) && Objects.equals(
                libro.getAutor().getNombre(), autor.getNombre())) {
                return libro;
            }
        }
        return null;
    }

    public LibroCopia registrarLibro(String nombre, String anho, Autor autor, String edicion) {
        System.out.println(
            "Registrando libro: " + nombre + ", anho: " + anho + " autor: " + autor.getNombre()
                + ", edicion: " + edicion);
        LibroTitulo libro = this.buscarLibro(nombre, autor);
        if (libro == null) {
            libro = new LibroTitulo(nombre, autor);
            libros.add(libro);
        }

        LibroCopia copia = new LibroCopia(libro, anho, edicion);
        libro.agregarCopia(copia);

        System.out.println("Registrando libro copia " + copia.getAnho());

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
        for (LibroTitulo l : libros) {
            if (l == libro) {
                for (LibroCopia copia : l.getCopias()) {
                    if (Objects.equals(copia.getEdicion(), edicion)) {
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

    public Estudiante registrarEstudiante(String nombre, String email, String celular,
        String area) {
        return new Estudiante(nombre, email, celular, area);
    }

    public void agregarOferta(String area, String temporada) {
        Oferta oferta = new Oferta(area, temporada);
        System.out.println("Agregar nueva oferta" + oferta.getArea() + " " + oferta.getTemporada());
        this.ofertas.add(oferta);
        this.notifyObservers(area);
    }

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String area) {
        for (Observer ob : this.observers) {
            ob.update(ob, area);
        }
    }
}
