package business;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author michelle
 */
public class Song {

    private String artist;
    private String title;

    // 1. Default constructor
    public Song() {
        this.artist = "Joe Bloggs";
        this.title = "Mmmbop";
    }

    // 2. Constructor with artist and title
    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    // 3. Getters and setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // 4. equals() and hashCode() based on artist and title
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return artist.equalsIgnoreCase(song.artist) && title.equals(song.title);
    }

    @Override
    public int hashCode() {
        return artist.toLowerCase().hashCode() * 31 + title.hashCode();
    }

    // 5. toString() method
    @Override
    public String toString() {
        return "Artist: " + artist + ", Title: " + title;
    }
}