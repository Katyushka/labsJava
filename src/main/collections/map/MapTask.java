/*
Решить задачу, используя отображения: реализовать простейший каталог музыкальных компакт-дисков, который позволяет:
•	Добавлять и удалять диски.
•	Добавлять и удалять песни.
•	Просматривать содержимое целого каталога и каждого диска в отдельности.
Осуществлять поиск всех записей заданного исполнителя по всему каталогу
 */

package main.collections.map;

import java.io.*;
import java.util.*;

/**
 * Created by ekaterina on 01.03.2017.
 */
public class MapTask implements Runnable {
    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new MapTask()).run();
    }

    public void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
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

    private void printMenu() {
        System.out.println("0: Exit");
        System.out.println("1: Add disk");
        System.out.println("2: Delete disk");
        System.out.println("3: Add song");
        System.out.println("4: Delete song");
        System.out.println("5: Show all catalog");
        System.out.println("6: Show disc content");
        System.out.println("7: Search singer's records");
    }

    private void addSong(HashMap<String, HashSet<Song>> catalog, HashMap<String, HashSet<String>> searchMap) {
        System.out.print("Enter song name and singer: ");
        Song song = new Song(nstr(), nstr());
        System.out.print("Enter disk name: ");
        String diskName = nstr();
        if (catalog.containsKey(diskName)) {
            catalog.get(diskName).add(song);
        } else {
            catalog.put(diskName, new HashSet<Song>() {{
                add(song);
            }});
        }
        if (searchMap.containsKey(song.getSinger())) {
            searchMap.get(song.getSinger()).add(song.getName());
        } else {
            searchMap.put(song.getSinger(), new HashSet<String>() {{
                add(song.getName());
            }});
        }
    }

    private void deleteSong(HashMap<String, HashSet<Song>> catalog, HashMap<String, HashSet<String>> searchMap) {
        System.out.print("Enter song name and singer: ");
        Song song = new Song(nstr(), nstr());
        // предполагается что одинаковые песни могут быть в разных дисках?
        System.out.print("Enter disk name: ");
        String diskName = nstr();
        if (catalog.containsKey(diskName)) {
            catalog.get(diskName).removeIf(song1 ->
                    Objects.equals(song1, song)
            );
        } else {
            System.out.println("Entered disk does not exist in catalog!");
        }
        if (searchMap.containsKey(song.getSinger())) {
            searchMap.get(song.getSinger()).removeIf(song1 ->
                    Objects.equals(song1, song.getName()));
        }
    }

    private void printCatalog(HashMap<String, HashSet<Song>> catalog) {
        catalog.forEach((disk, songs) -> {
            System.out.println("Disk : " + disk);
            printSongs(songs);
        });
    }

    private void printDiskContent(HashMap<String, HashSet<Song>> catalog) {
        System.out.print("Enter disk name : ");
        String disk = nstr();
        if (catalog.containsKey(disk)) {
            HashSet<Song> songs = catalog.get(disk);
            printSongs(songs);
        } else {
            System.out.println("Entered disk does not exist in catalog!");
        }
    }

    private void printSongs(HashSet<Song> songs) {
        songs.forEach(song -> {
            System.out.println("\t Song name : " + song.getName() + " , singer : " + song.getSinger());
        });
    }

    private void searchRecords(HashMap<String, HashSet<String>> searchMap) {
        System.out.print("Enter singer: ");
        String singer = nstr();
        if (searchMap.containsKey(singer)) {
            searchMap.get(singer).forEach(System.out::println);
        } else {
            System.out.println("Entered singer does not exist in catalog!");
        }
    }


    private void solver() {
        HashMap<String, HashSet<Song>> catalog = new HashMap<>();
        HashMap<String, HashSet<String>> searchMap = new HashMap<>();
        printMenu();
        int act = ni();
        while (act != 0) {
            switch (act) {
                case 0:
                    exit();
                    break;
                case 1:
                    System.out.print("Enter disk name: ");
                    catalog.put(nstr(), new HashSet());
                    break;
                case 2:
                    System.out.print("Enter deleted disk name: ");
                    catalog.remove(nstr());
                    break;
                case 3:
                    addSong(catalog, searchMap);
                    break;
                case 4:
                    deleteSong(catalog, searchMap);
                    break;
                case 5:
                    printCatalog(catalog);
                    break;
                case 6:
                    printDiskContent(catalog);
                    break;
                case 7:
                    searchRecords(searchMap);
                    break;
            }
            printMenu();
            act = ni();
        }
    }
}
