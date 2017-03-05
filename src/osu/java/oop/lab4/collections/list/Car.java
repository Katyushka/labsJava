package osu.java.oop.lab4.collections.list;

/**
 * Created by ekaterina on 26.02.2017.
 */
public class Car {
    private String model;
    private String number;
    private String ownerSurname;
    private int year;
    private int mileage;

    public Car(String model, String number, String ownerSurname, int year, int mileage) {
        this.model = model;
        this.number = number;
        this.ownerSurname = ownerSurname;
        this.year = year;
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return this.getModel() + " " + this.getNumber() + " " + this.getOwnerSurname() + " " + this.getYear() + " " + this.getMileage();
    }
}
