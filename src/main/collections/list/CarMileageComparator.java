package main.collections.list;

import java.util.Comparator;

/**
 * Created by ekaterina on 26.02.2017.
 */
public class CarMileageComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getMileage() > o2.getMileage()) return 1;
        else if (o1.getMileage() < o2.getMileage()) return -1;
        else
            return 0;
    }
}
