package tasos.mdb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.mappers.MovieMapper;
import tasos.mdb.models.Movie;
import tasos.mdb.services.movie.MovieService;

import java.net.URI;
import java.net.URISyntaxException;

//domain/api/v1/movies
@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }


    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                movieMapper.movieToMovieDTO(
                movieService.findAll())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Movie entity) throws URISyntaxException {
        //Add movie
        movieService.add(entity);
        URI uri = new URI("api/v1/movies/"+entity.getId());
        return ResponseEntity.created(uri).build();
    }
}
