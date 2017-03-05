package osu.oop.lab4.collections.map;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof Song)) {
            return false;
        }
        Song song = (Song) object;
        return new EqualsBuilder()
                .append(name, song.name)
                .append(singer, song.singer)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(singer)
                .toHashCode();
    }

}
