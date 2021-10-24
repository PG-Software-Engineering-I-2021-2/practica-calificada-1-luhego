package app;

public class Oferta {
    private String area;
    private String temporada;

    public Oferta(String area, String temporada) {
        this.area = area;
        this.temporada = temporada;
    }

    public String getArea() {
        return area;
    }

    public String getTemporada() {
        return temporada;
    }
}
