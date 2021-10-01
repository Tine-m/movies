package movieapp.controllers;

import movieapp.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController {

    private MovieService movieService = new MovieService();

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome to Movie App";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public String findAll() {
        return movieService.findAllMovies().toString();
    }

    @GetMapping("/getMovie")
    @ResponseBody
    public String findByTitle(@RequestParam String title) {
        return movieService.findMovieByTitle(title).toString();
    }
}
