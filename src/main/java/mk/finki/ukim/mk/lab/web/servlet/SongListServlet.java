//package mk.finki.ukim.mk.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Genre;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.GenreService;
//import mk.finki.ukim.mk.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//
//    private final SongService service;
//    private final SpringTemplateEngine templateEngine;
//    private final GenreService genreService;
//
//
//    public SongListServlet(SongService service, SpringTemplateEngine templateEngine, GenreService genreService) {
//        this.service = service;
//        this.templateEngine = templateEngine;
//        this.genreService = genreService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("genres", genreService.listGenres());
//
//        String genre = req.getParameter("genre");
//        if (genre != null && !genre.isEmpty()) {
//            context.setVariable("songs", service.findSongsByGenre(new Genre(genre)));
//        } else {
//            context.setVariable("songs", service.listSongs());
//        }
//
//        templateEngine.process("listSongs.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String trackID = req.getParameter("trackID");
//
//        Song song = service.findByTrackId(trackID);
//
//        req.getSession().setAttribute("song", song);
//        resp.sendRedirect("/artist");
//    }
//}
