package osu.java.oop.lab2;

/**
 * Created by ekaterina on 15.02.2017.
 */
public class Locality implements Comparable{
    private int population;
    private double area;
    private double density;


    public Locality(int population, double area) {
        this.population = population;
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }



    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double calculateDensity() {
        return this.population / this.area;
    }

    public Status calculateStatus(int population) {
        if (population > 3000000) return Status.SUPERLARGE_CITY;
        else if (population > 1000000) return Status.LARGEST_CITY;
        else if (population > 250000) return Status.LARGE_CITY;
        else if (population > 100000) return Status.BIG_CITY;
        else if (population > 50000) return Status.MEDIUM_CITY;
        else if (population > 12000) return Status.SMALL_CITY_VILLAGE;
        else if (population > 5000) return Status.LARGE_RURAL_SETTLEMENT;
        else if (population > 1000) return Status.BIG_RURAL_SETTLEMENT;
        else if (population > 200) return Status.MEDIUM_RURAL_SETTLEMENT;
        else return Status.SMALL_RURAL_SETTLEMENT;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public int compareTo(Object o) {
        Locality locality = (Locality)o;
        if (this.population < locality.population){
            return -1;
        } else if (this.population > locality.population){
            return 1;
        }
        return 0;
    }
}
