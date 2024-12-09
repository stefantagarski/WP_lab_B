package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String trackID;

    private int releaseYear;


    @ManyToOne
    private Album album;

    public Song(String title, String trackID, int releaseYear, Album album) {
        this.title = title;
        this.trackID = trackID;
        this.releaseYear = releaseYear;
        this.album = album;
    }
}
