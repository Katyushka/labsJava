package main.collections.map;

import java.util.Objects;

/**
 * Created by ekaterina on 01.03.2017.
 */
public class Song {
    private String name;
    private String singer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    @Override
    public boolean equals(Object object){
        Song song = (Song)object;
        if (this.getName().equals(song.getName()) && this.getSinger().equals(song.getSinger()))
        return true;
        return false;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.getSinger().hashCode()+this.getName().hashCode();
        return result;
    }

}
