package osu.oop.lab2;

import javax.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ekaterina on 28.02.2017.
 */
public class Main implements Runnable{

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new Main()).run();
    }

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



    public void solver(){
        Locality locality = new Locality("Locality", 800, 200);
        locality.print();

        Locality localityCity = new City("Locality-City", 10, 10);
        //localityCity.setUniversities(10); - не доступен метод
        localityCity.print();

        City city = new City("City", 1000, 500);
        city.setUniversities(5);
        city.print();
        city.setUniversities(5);
        System.out.println("universities = " + city.getUniversities());

        Village village = new Village("Village", 100, 2000);
        village.print();

        System.out.println();

        ArrayList<Locality> localities = new ArrayList<>();
        localities.add(locality);
        localities.add(city);
        localities.add(village);
        localities.add(localityCity);
        Collections.sort(localities);


        localities.forEach(locality1 -> locality1.print());


    }

}
