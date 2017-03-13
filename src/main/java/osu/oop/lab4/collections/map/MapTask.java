/*
Решить задачу, используя отображения: реализовать простейший каталог музыкальных компакт-дисков, который позволяет:
•	Добавлять и удалять диски.
•	Добавлять и удалять песни.
•	Просматривать содержимое целого каталога и каждого диска в отдельности.
Осуществлять поиск всех записей заданного исполнителя по всему каталогу
 */

package osu.oop.lab4.collections.map;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ekaterina on 01.03.2017.
 */
public class MapTask implements Runnable {
    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");
    private HashMap<String, HashSet<Song>> catalog = new HashMap<>();
    private HashMap<String, HashSet<String>> searchMap = new HashMap<>();

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

    private void addSong() {
        System.out.print("Enter song name and singer: ");
        Song song = new Song(nstr(), nstr());
        System.out.print("Enter disk name: ");
        String diskName = nstr();
        catalog.merge(diskName, new HashSet<Song>(){{add(song);}}, (oldSongs, newSong)->{oldSongs.addAll(newSong); return oldSongs;});
        searchMap.merge(song.getSinger(), new HashSet<String>(){{add(song.getName());}}, (oldSongs, newSong)->{oldSongs.addAll(newSong); return oldSongs;} );

    }

    private void deleteSong() {
        System.out.print("Enter song name and singer: ");
        Song song = new Song(nstr(), nstr());
        // предполагается что одинаковые песни могут быть в разных дисках
        System.out.print("Enter disk name: ");
        String diskName = nstr();
        if (catalog.containsKey(diskName)) {
            catalog.get(diskName).removeIf(songFromDisk ->
                    Objects.equals(songFromDisk, song)
            );
        } else {
            System.out.println("Entered disk does not exist in catalog!");
        }
        if (searchMap.containsKey(song.getSinger())) {
            searchMap.get(song.getSinger()).removeIf(songNameFromHash ->
                    Objects.equals(songNameFromHash, song.getName()));
        }
    }

    private void printCatalog() {
        catalog.forEach((disk, songs) -> {
            System.out.println("Disk : " + disk);
            printSongs(songs);
        });
    }

    private void printDiskContent() {
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

    private void searchRecords() {
        System.out.print("Enter singer: ");
        String singer = nstr();
        if (searchMap.containsKey(singer)) {
            searchMap.get(singer).forEach(System.out::println);
        } else {
            System.out.println("Entered singer does not exist in catalog!");
        }
    }

    private void solver() {
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
                    addSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    printCatalog();
                    break;
                case 6:
                    printDiskContent();
                    break;
                case 7:
                    searchRecords();
                    break;
            }
            printMenu();
            act = ni();
        }
    }
}
