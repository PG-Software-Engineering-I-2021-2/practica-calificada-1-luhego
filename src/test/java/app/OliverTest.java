package app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OliverTest {
    @Test
    public void testRegistrarLibros() {
        Oliver oliver = Oliver.getInstance();

        Autor autor = new Autor("Sommerfield", "18/11/1990");
        oliver.registrarLibro("Software Engineering", "1990", autor, "6th edition");
        oliver.registrarLibro("Software Engineering", "1990", autor, "7th edition");
        oliver.registrarLibro("Software Engineering", "1990", autor, "8th edition");
        oliver.registrarLibro("Software Engineering", "1990", autor, "9th edition");

        Assert.assertEquals(oliver.getLibros().size(), 4);
    }
}
