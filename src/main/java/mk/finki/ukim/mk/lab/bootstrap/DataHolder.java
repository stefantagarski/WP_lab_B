package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Genre;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();
    public static List<Genre> genreList = new ArrayList<>();

    @PostConstruct
    public void init() {
        genreList.add(new Genre("Rock"));
        genreList.add(new Genre("Pop"));
        genreList.add(new Genre("Metal"));

        artistList.add(new Artist(1L, "Lenny", "Kravitz", "Leonard Albert Kravitz is an American singer, songwriter, musician, record producer, and actor."));
        artistList.add(new Artist(2L, "The", "Weeknd", "Abel Makkonen Tesfaye, known professionally as The Weeknd, is a Canadian singer, songwriter, and record producer."));
        artistList.add(new Artist(3L, "Michael", "Jackson", "Michael Joseph Jackson was an American singer, songwriter, and dancer."));
        artistList.add(new Artist(4L, "Prince", "", "Prince Rogers Nelson was an American singer, songwriter, musician, record producer, and filmmaker."));
        artistList.add(new Artist(5L, "David", "Bowie", "David Robert Jones, known professionally as David Bowie, was an English singer-songwriter and actor."));

        songList.add(new Song("1", "Are You Gonna Go My Way", new Genre("Rock"), 1998, new ArrayList<>()));
        songList.add(new Song("2", "Fly Away", new Genre("Rock"), 1998, new ArrayList<>()));
        songList.add(new Song("3", "Enter Sandman", new Genre("Metal"), 1991, new ArrayList<>()));
        songList.add(new Song("4", "Thriller", new Genre("Pop"), 1982, new ArrayList<>()));
        songList.add(new Song("5", "Billie Jean", new Genre("Pop"), 1982, new ArrayList<>()));

    }
}
