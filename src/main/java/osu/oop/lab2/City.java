package osu.oop.lab2;

/**
 * Created by ekaterina on 15.02.2017.
 */
public class City extends Locality {

    private int universities;

    public City(String name, int population, double area) {
        super(name, population, area);
    }

    public int getUniversities() {
        return universities;
    }

    public void setUniversities(int universities) {
        this.universities = universities;
    }

}