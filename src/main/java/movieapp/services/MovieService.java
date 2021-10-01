package movieapp.services;

import movieapp.repositories.MovieRepository;
import movieapp.models.Movie;

import java.util.List;

public class MovieService {

    private MovieRepository movieRepository = new MovieRepository();

    public List<Movie> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public Movie findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }
}
