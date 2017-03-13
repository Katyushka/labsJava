package osu.oop.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ekaterina on 06.03.2017.
 */

public class LocalityTest {

    @Test
    public void calculateDensityTest() {
        Locality locality = new Locality("Test locality", 100, 20);
        assertEquals("Density must be 5", 5, locality.calculateDensity(), 0);
    }
}
