package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String ArtistPage(Model model) {
        List<Artist> artists = artistService.listArtists();
        model.addAttribute("artists", artists);
        return "artistsList";
    }

    @PostMapping("/addArtist")
    public String addArtist(@RequestParam Long artistID, HttpSession session){
        Artist artist = artistService.artistFindById(artistID).get();
        Song song = (Song) session.getAttribute("song");

       // session.setAttribute("artists", songService.addArtistToSong(artist, song));
        return "redirect:/songDetailsPage";
    }
}
