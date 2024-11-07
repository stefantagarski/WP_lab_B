package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {

    private final SongService songService;
    private final SpringTemplateEngine templateEngine;
    private final ArtistService artistService;

    public ArtistServlet(SongService songService, SpringTemplateEngine templateEngine, ArtistService artistService) {
        this.songService = songService;
        this.templateEngine = templateEngine;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("artists", artistService.listArtists());
        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long artistID = Long.parseLong(req.getParameter("artistID"));

        Optional<Artist> artist = artistService.artistFindById(artistID);


        Song song = (Song) req.getSession().getAttribute("song");

        Artist artists = songService.addArtistToSong(artist.orElse(null), song);

        req.getSession().setAttribute("artists", artists);
        resp.sendRedirect("/songDetails");

    }
}
