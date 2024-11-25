package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Genre;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.GenreRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final GenreRepository genreRepository;
    private final AlbumRepository albumRepository;


    public SongServiceImpl(SongRepository repository, GenreRepository genreRepository, AlbumRepository albumRepository) {
        this.songRepository = repository;
        this.genreRepository = genreRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Optional<Song> findSongByID(Long id) {
        return songRepository.findSongByID(id);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public List<Song> findSongsByGenre(Genre genre) {
        return songRepository.searchByGenre(genre);
    }

    @Override
    public Optional<Song> saveOrUpdate(String name, String trackID, int releaseYear, Long genreID, Long albumID) {
        Genre genre = genreRepository.findByID(genreID).orElse(null);
        Album album = albumRepository.findByID(albumID).orElse(null);

        return songRepository.saveOrUpdate(name, trackID, releaseYear, genre, album);
    }

    @Override
    public void deleteByID(Long id) {
        songRepository.deleteByID(id);
    }
}
