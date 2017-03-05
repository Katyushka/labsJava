package osu.java.oop.lab2;

/**
 * Created by ekaterina on 15.02.2017.
 */
public class City extends Locality {

    private int universities;

    public City(int population, double area) {
        super(population, area);
    }


    public int getUniversities() {
        return universities;
    }

    public void setUniversities(int universities) {
        this.universities = universities;
    }
}
