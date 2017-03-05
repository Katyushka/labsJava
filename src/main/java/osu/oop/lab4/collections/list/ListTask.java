/*
4.	На основе данных входного файла составить автомобильную ведомость, включив следующие данные: марка автомобиля,
номер автомобиля, фамилия его владельца,  год приобретения, пробег. Вывести в новый файл информацию об автомобилях,
выпущенных ранее определенного года, отсортировав их по пробегу.
 */

package osu.oop.lab4.collections.list;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ekaterina on 26.02.2017.
 */
public class ListTask implements Runnable {


    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new ListTask()).run();
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new FileReader("input.txt"));
            pw = new PrintWriter("output.txt");
        } catch
                (FileNotFoundException e) {
            e.printStackTrace();
        }
        solver();
        pw.close();
    }

    private void nline() {
        try {
            if (!stk.hasMoreTokens())
                stk = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Runtime Ex!!!", e);
        }
    }

    private String nstr() {
        while (!stk.hasMoreTokens())
            nline();
        return stk.nextToken();
    }

    private int ni() {
        return Integer.valueOf(nstr());
    }

    private long nl() {
        return Long.valueOf(nstr());
    }

    private double nd() {
        return Double.valueOf(nstr());
    }

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    void exit() {
        System.exit(0);
    }


    public void solver() {
        int n = ni(), year = ni();
        Comparator<Car> carComparator = new CarMileageComparator();
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Car car = new Car(nstr(), nstr(), nstr(), ni(), ni());
            cars.add(car);
        }
        cars.sort(carComparator);

        for (int i = 0; i < n; i++) {
            if (cars.get(i).getYear() < year) {
                pw.println(cars.get(i).toString());
            }
        }
    }
}

/* input
5 2009
ford Е234АВ Петров 2001 100
kia A234АМ Иванов 2008 70
lada Е234НВ Васин 2010 85
opel B234НО Смирнов 2005 120
ford K234СТ Орлов 2013 95
 */
