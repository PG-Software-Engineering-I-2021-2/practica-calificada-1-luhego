package app;

public class Estudiante {
    private String nombre;
    private String email;
    private String celular;

    public Estudiante(String nombre, String email, String celular) {
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }
}
