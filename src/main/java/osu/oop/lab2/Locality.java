package osu.oop.lab2;

import java.util.ArrayList;

/**
 * Created by ekaterina on 15.02.2017.
 */
public class Locality implements Comparable, Printable {
    private String name;
    private int population;
    private double area;
    private double density;

    public Locality(String name, int population, double area) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double calculateDensity() {
        double density = 0;
        try {
            density = this.population / this.area;
        } catch (ArithmeticException e) {
            System.out.println("caught " + e);
        }
        return density;
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

    @Override
    public int compareTo(Object o) {
        Locality locality = (Locality) o;
        if (this.population < locality.population) {
            return -1;
        } else if (this.population > locality.population) {
            return 1;
        }
        return 0;
    }

    @Override
    public void print() {
        System.out.println("name = " + this.getName() + ": population = " + this.getPopulation()+ ", area = " + this.getArea() + ", density = "+ calculateDensity());
    }

}
