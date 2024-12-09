package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemorySongRepository {
    public List<Song> findAll() {
        return DataHolder.songList;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.songList.stream().filter(r -> r.getTrackID()
                .equals(trackId)).findFirst().orElse(null);
    }

    public Optional<Song> findSongByID(Long id) {
        return DataHolder.songList.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

//    public Artist addArtistToSong(Artist artist, Song song) {
//        if (!song.getPerformers().contains(artist)) {
//            song.getPerformers().add(artist);
//        }
//        return artist;
//    }
//    public List<Song> searchByGenre(Genre genre) {
//        return DataHolder.songList.stream().filter(r -> r.getGenre().getName().equals(genre.getName()))
//                .toList();
//    }

//    public Optional<Song> saveOrUpdate(String name, String trackID, int releaseYear, Genre genre, Album album) {
//        Song song = new Song(name, trackID, genre, new ArrayList<>(), releaseYear, album);
//        DataHolder.songList.removeIf(r -> r.getTrackID().equals(trackID));
//        DataHolder.songList.add(song);
//        return Optional.of(song);
//    }

    public void deleteByID(Long id) {
        DataHolder.songList.removeIf(r -> r.getId().equals(id));
    }
}
