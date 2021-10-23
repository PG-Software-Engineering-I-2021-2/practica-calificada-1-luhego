package app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {
    @Test
    public void testSum() {
        Demo demo = new Demo();
        Assert.assertEquals(demo.sum(3, 5), 8);
    }
}
