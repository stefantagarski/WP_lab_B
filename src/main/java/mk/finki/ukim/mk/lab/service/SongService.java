package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Genre;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();

    Artist addArtistToSong(Artist artist, Song song);

    Optional<Song> findSongByID(Long id);

    Song findByTrackId(String trackId);

    List<Song> findSongsByGenre(Genre genre);

    Optional<Song> saveOrUpdate(String name, String trackID, int releaseYear, Long genreID, Long albumID);

    void deleteByID(Long id);
}