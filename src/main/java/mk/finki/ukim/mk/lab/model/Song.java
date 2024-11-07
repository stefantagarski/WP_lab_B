package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Song {
    String trackId;
    String title;
    Genre genre;
    int releaseYear;
    List<Artist> performers;
}
