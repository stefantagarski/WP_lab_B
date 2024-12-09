package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();

    Optional<Song> findSongByID(Long id);

    Song findByTrackId(String trackId);

    Optional<Song> save(String name, String trackID, int releaseYear, Long albumID);

    Optional<Song> update(Long id, String name, String trackID, int releaseYear, Long albumID);

   List<Song> findAllByAlbum_Id (Long albumId);

    void deleteByID(Long id);
}