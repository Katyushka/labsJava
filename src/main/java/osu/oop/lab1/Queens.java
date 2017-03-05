package osu.oop.lab1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by ekaterina on 13.02.2017.
 */

public class Queens implements Runnable {

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new Queens()).run();
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


    int n;
    //текущее решение
    int solution[];
    int solutionNumber = 0;

    private void solver() {
        n = ni();
        solution = new int[n];
        search(0);
    }

    // Функция выводит найденное решение на экран
    private void print() {
        pw.println("---перестановка " + (++solutionNumber) + "---");
        pw.print(" ");
        for (int i = 0; i < n; i++)
            pw.print("___");
        pw.print("__");
        pw.println();
        for (int i = 0; i < n; i++) {
            pw.print((n - i) + "|");
            for (int j = 0; j < n; j++) {
                pw.print((solution[i] == j) ? " Ф " : " . ");
            }
            pw.print("|");
            pw.println();
        }
        pw.print(" |");
        for (int i = 0; i < n; i++)
            pw.print("___");
        pw.print("|");
        pw.println();
    }

    // параметр - номер строки для которой ищем позицию ферзя
    private void search(int rowNumber) {
        int columnNumber = 0;
        while (columnNumber < n) {
            if (check(rowNumber, columnNumber)) {
                solution[rowNumber] = columnNumber;
                if (rowNumber < n - 1) {
                    search(rowNumber + 1);
                } else {
                    print();
                }
                solution[rowNumber] = 0;
            }
            columnNumber++;
        }
    }

    // Проверка на то бьют ли два ферзя друг друга
    private boolean check(int x, int y) {
        boolean isGood = true;
        for (int i = 0; i < x; i++) {
            if (solution[i] == y)
                return false;
            if (checkDiagonal(i, solution[i], x, y))
                return false;
        }
        return isGood;
    }


    private boolean checkDiagonal(int x1, int y1, int x2, int y2) {
        boolean isBeat = Math.abs(x1 - x2) == Math.abs(y1 - y2) ? true : false;
        return isBeat;
    }

    void exit() {
        System.exit(0);
    }

}


