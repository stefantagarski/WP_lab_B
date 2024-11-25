package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songDetailsPage")
public class SongDetailsController {
    @GetMapping
    public String SongDetailsPage() {
        return "songDetails";
    }
}
