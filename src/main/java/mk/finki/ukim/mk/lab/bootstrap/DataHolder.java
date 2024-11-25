package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
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
    public static List<Album> albumList = new ArrayList<>();

    @PostConstruct
    public void init() {
        genreList.add(new Genre("Rock"));
        genreList.add(new Genre("Pop"));
        genreList.add(new Genre("Metal"));

        artistList.add(new Artist(1L, "Lenny", "Kravitz", "Leonard Albert Kravitz is an American singer, songwriter, musician, record producer, and actor."));
        artistList.add(new Artist(2L, "The", "Weeknd", "Abel Makkonen Tesfaye, known professionally as The Weeknd, is a Canadian singer, songwriter, and record producer."));
        artistList.add(new Artist(3L, "Michael", "Jackson", "Michael Joseph Jackson was an American singer, songwriter, and dancer."));
        artistList.add(new Artist(4L, "Prince", "Price", "Prince Rogers Nelson was an American singer, songwriter, musician, record producer, and filmmaker."));
        artistList.add(new Artist(5L, "David", "Bowie", "David Robert Jones, known professionally as David Bowie, was an English singer-songwriter and actor."));

        albumList.add(new Album("Album1", "Rock","1992"));
        albumList.add(new Album("Album2", "Rock","1998"));
        albumList.add(new Album("Album3", "Metal","1997"));
        albumList.add(new Album("Album4", "Pop","1982"));
        albumList.add(new Album("Album5", "Pop","1987"));

        songList.add(new Song("Low", "1",genreList.get(0),new ArrayList<>(), 1998, albumList.get(0)));
        songList.add(new Song("Fly Away", "2",genreList.get(0), new ArrayList<>(), 1998, albumList.get(1)));
        songList.add(new Song("Enter Sandman", "3",genreList.get(2), new ArrayList<>(), 1997, albumList.get(2)));
        songList.add(new Song("Thriller", "3",genreList.get(1), new ArrayList<>(), 1982, albumList.get(3)));
        songList.add(new Song("Bad", "4",genreList.get(1), new ArrayList<>(), 1987, albumList.get(4)));
        songList.add(new Song("Let's Dance", "4",genreList.get(1), new ArrayList<>(), 1983, albumList.get(4)));

    }
}