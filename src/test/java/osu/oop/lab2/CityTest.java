package osu.oop.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by ekaterina on 06.03.2017.
 */


public class CityTest {

    @Test
    public void getUniversitiesTest(){
        City city = new City("Test city", 1000, 300);
        city.setUniversities(3);
        assertEquals("Count of universities must be 3", 3, city.getUniversities());
    }
}
