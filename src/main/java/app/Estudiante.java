package app;

import java.util.logging.Logger;

public class Estudiante implements Observer {
    private String nombre;
    private String email;
    private String celular;
    private String area;
    private static final Logger logger = Logger.getLogger(Estudiante.class.getName());

    public Estudiante(String nombre, String email, String celular, String area) {
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    @Override
    public void update(Observer observer, String area) {
        if (this.area == area) {
            logger.info("Hay una nueva oferta para el area " + area);
        }
    }
}
