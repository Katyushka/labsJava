/*
4.	Даны 2 строки s1 и s2. Из каждой можно читать по одному символу. Выяснить, является ли строка s2 обратной s1.
 */

package osu.java.oop.lab4.collections;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ekaterina on 26.02.2017.
 */
public class StackTask implements Runnable {
    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new StackTask()).run();
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


    private void solver() {
        String s1 = nstr(), s2 = nstr();
        Stack<Character> st = new Stack();
        if (s1.length() != s2.length()) {
            pw.print("Strings are not reversed!");
            pw.close();
            exit();
        }
        for (int i = 0; i < s2.length(); i++) {
            st.push(s2.charAt(i));
        }
        int i = 0;
        while (i < s1.length()) {
            //Character c = st.peek();
            //Character c1 = s1.charAt(i);
            if (!st.pop().equals(s1.charAt(i))) {
                pw.print("Strings are not reversed!");
                pw.close();
                exit();
            }
            i++;
        }
        pw.print("Strings are reversed!");
    }


    void exit() {
        System.exit(0);
    }
}
