package tasos.mdb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.mappers.MovieMapper;
import tasos.mdb.models.DTO.Movies.MovieDTO;
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
        return ResponseEntity.ok(movieMapper.movieToMovieDTO(movieService.findById(id)));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody MovieDTO entity) throws URISyntaxException {
        //Add movie
        //movieService.add(entity);
        movieService.add(movieMapper.movieDTOtoMovie(entity));
        //movieMapper.movieDTOtoMovie();
        URI uri = new URI("api/v1/movies/"+entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody MovieDTO entity, @PathVariable int id){
        if(id!= entity.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDTOtoMovie(entity));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}/characters")
    public ResponseEntity getCharacters(@PathVariable int id){

        return ResponseEntity.ok(movieService.getCharacters(id));
    }

    @PutMapping("{id}/characters")
    public ResponseEntity updateCharacters(@PathVariable int id,@RequestBody int[] filmCharactersId){
        movieService.updateCharacters(id,filmCharactersId);
        return ResponseEntity.noContent().build();
    }
}
