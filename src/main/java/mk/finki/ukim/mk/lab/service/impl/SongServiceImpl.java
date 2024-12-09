package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.model.exceptions.NoAlbumIDFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.NoSongIDFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;


    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;

    }


    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }


    @Override
    public Optional<Song> findSongByID(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackID(trackId);
    }

    @Override
    public Optional<Song> save(String name, String trackID, int releaseYear, Long albumID) {
        Album album = albumRepository.findById(albumID).orElseThrow(() -> new NoAlbumIDFoundException(albumID));

        Song song = new Song(name, trackID, releaseYear, album);

        return Optional.of(songRepository.save(song));

    }

    @Override
    public Optional<Song> update(Long id, String name, String trackID, int releaseYear, Long albumID) {
        Album album = albumRepository.findById(albumID).orElseThrow(() -> new NoAlbumIDFoundException(albumID));

        Song song = songRepository.findById(id).orElseThrow(() -> new NoSongIDFoundException(albumID));

        song.setTitle(name);
        song.setTrackID(trackID);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);

        return Optional.of(songRepository.save(song));
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }



    @Override
    public void deleteByID(Long id) {
        songRepository.deleteById(id);
    }
}
