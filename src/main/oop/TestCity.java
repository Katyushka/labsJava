package main.oop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ekaterina on 27.02.2017.
 */
public class TestCity {

    @Test
    public void TestCalculateDensity(){
        City city = new City(1000, 250);
        city.setDensity(city.calculateDensity());
        assertTrue(city.getDensity()==4);
    }

}
