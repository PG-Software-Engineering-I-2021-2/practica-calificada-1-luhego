package app;

public class LibroCopia {
    private LibroTitulo libroTitulo;
    private String edicion;
    private String anho;

    public LibroCopia(LibroTitulo libroTitulo, String anho, String edicion) {
        this.libroTitulo = libroTitulo;
        this.anho = anho;
        this.edicion = edicion;
    }

    public LibroTitulo getLibroTitulo() {
        return libroTitulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getAnho() {
        return anho;
    }
}
