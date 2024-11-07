package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository repository;

    public SongServiceImpl(SongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> listSongs() {
        return repository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return repository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return repository.findByTrackId(trackId);
    }
}
