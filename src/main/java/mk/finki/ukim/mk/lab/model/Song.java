package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Song {
    private Long id;
    private String title;
    private String trackID;
    private Genre genre;
    private int releaseYear;
    private List<Artist> performers;
    private Album album;

    public Song(String title, String trackID,Genre genre, List<Artist> performers, int releaseYear, Album album) {
        this.id = (long)(Math.random() * 1000);
        this.title = title;
        this.trackID = trackID;
        this.genre = genre;
        this.performers = performers;
        this.releaseYear = releaseYear;
        this.album = album;
    }
}
