/*
4.	Дан файл, содержащий числа. За один просмотр файла напечатать элементы файла в следующем порядке:
сначала все положительные числа, потом все отрицательные числа,  сохраняя исходный порядок в каждой группе чисел.
 */

package osu.java.oop.lab4.collections;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ekaterina on 26.02.2017.
 */
public class QueueTask implements Runnable {

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new QueueTask()).run();
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
        int n = ni();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int number = ni();
            if (number >= 0) pw.print(number + " ");
            else queue.offer(number);
        }
        while (!queue.isEmpty()) {
            pw.print(queue.poll() + " ");
        }
    }
}

/*
input
10
6 5 -2 6 -1 2 -7 8 9 1
*/
