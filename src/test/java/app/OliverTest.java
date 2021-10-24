package app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OliverTest {
    @Test
    public void testOliver() {
        Oliver oliver = Oliver.getInstance();

        Autor sommerfield = new Autor("Sommerfield", "18/11/1990");
        oliver.registrarLibro("Software Engineering", "1980", sommerfield, "6th edition");
        oliver.registrarLibro("Software Engineering", "1981", sommerfield, "7th edition");
        oliver.registrarLibro("Software Engineering", "1982", sommerfield, "8th edition");
        oliver.registrarLibro("Software Engineering", "1983", sommerfield, "9th edition");

        Autor bob = new Autor("Robert Martin", "18/10/1970");
        oliver.registrarLibro("Clean Code", "1990", bob, "6th edition");
        oliver.registrarLibro("Clean Code", "1991", bob, "7th edition");
        oliver.registrarLibro("Clean Code", "1992", bob, "8th edition");
        oliver.registrarLibro("Clean Code", "1993", bob, "9th edition");

        Assert.assertEquals(oliver.getLibros().size(), 8);

        Assert.assertEquals(oliver.buscarLibrosPorAuthor(sommerfield).size(), 4);

    }
}
