package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Genre;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.GenreService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final GenreService genreService;
    private final AlbumService albumService;

    public SongController(SongService songService, GenreService genreService, AlbumService albumService) {
        this.songService = songService;
        this.genreService = genreService;
        this.albumService = albumService;
    }

    @GetMapping()
    public String getSongsPage(@RequestParam(required = false) String error, Model model,
                               @RequestParam(required = false) String genre) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("genres", genreService.listGenres());

        if (genre != null && !genre.isEmpty()) {
            model.addAttribute("songs", songService.findSongsByGenre(new Genre(genre)));
        }else {
            model.addAttribute("songs", songService.listSongs());
        }
        return "listSongs";
    }

    @GetMapping("/delete-form/{id}")
    public String deletePage(@PathVariable Long id, Model model) {
        Song song = songService.findSongByID(id).get();
        List<Genre> genres = genreService.listGenres();
        List<Album> albums = albumService.findAll();

        model.addAttribute("song",song);
        model.addAttribute("genres", genres);
        model.addAttribute("albums", albums);

        return "delete-song";
    }

    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteByID(id);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        if (songService.findSongByID(id).isPresent()) {
            Song song = songService.findSongByID(id).get();
            List<Genre> genres = genreService.listGenres();
            List<Album> albums = albumService.findAll();

            model.addAttribute("song",song);
            model.addAttribute("genres", genres);
            model.addAttribute("albums", albums);
            return "add-song";
        }
        return "redirect:/songs?error=NoSongIDFound";
    }

    @GetMapping("/add-Song")
    public String addSong(Model model) {
        List<Genre> genres = genreService.listGenres();
        List<Album> albums = albumService.findAll();

        model.addAttribute("genres", genres);
        model.addAttribute("albums", albums);
        return "add-song";
    }

    @PostMapping("/add")
    public String saveOrUpdate(@RequestParam String  name,
                               @RequestParam String trackID,
                               @RequestParam int releaseYear,
                               @RequestParam Long genreID,
                               @RequestParam Long albumID){

        songService.saveOrUpdate(name, trackID, releaseYear, genreID, albumID);
        return "redirect:/songs";
    }

    @PostMapping("/listArtist")
    public String ArtistListPage(@RequestParam String trackID, HttpSession session) {
        Song song = songService.findByTrackId(trackID);
        session.setAttribute("song", song);
        return "redirect:/artist";
    }

}
