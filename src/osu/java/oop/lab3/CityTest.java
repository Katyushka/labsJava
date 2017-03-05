package osu.java.oop.lab3;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import osu.java.oop.lab2.*;

/**
 * Created by ekaterina on 27.02.2017.
 */
public class CityTest {

    @Test
    public void TestCalculateDensity(){
        City city = new City(1000, 250);
        city.setDensity(city.calculateDensity());
        assertTrue(city.getDensity()==4);
    }

}
