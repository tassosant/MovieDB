package tasos.mdb.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.mappers.filmCharacters.FilmCharacterMapper;
import tasos.mdb.mappers.movies.MovieMapper;
import tasos.mdb.models.DTO.FilmCharacters.FilmCharacterDTO;
import tasos.mdb.models.DTO.Movies.MovieDTO;
import tasos.mdb.services.movie.MovieService;

import java.net.URI;
import java.net.URISyntaxException;

//domain/api/v1/movies
@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    private final FilmCharacterMapper filmCharacterMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper, FilmCharacterMapper filmCharacterMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.filmCharacterMapper = filmCharacterMapper;
    }


    @GetMapping
    @Operation(summary = "Gets all the movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovieDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
                movieMapper.movieToMovieDTO(
                movieService.findAll())
        );
    }

    @GetMapping("{id}")
    @Operation(summary = "Gets a movie by their ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(movieMapper.movieToMovieDTO(movieService.findById(id)));
    }
    @PostMapping
    @Operation(summary = "Adds a new movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity add(@RequestBody MovieDTO entity) throws URISyntaxException {
        //Add movie
        //movieService.add(entity);
        movieService.add(movieMapper.movieDTOtoMovie(entity));
        //movieMapper.movieDTOtoMovie();
        URI uri = new URI("api/v1/movies/"+entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity update(@RequestBody MovieDTO entity, @PathVariable int id){
        if(id!= entity.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDTOtoMovie(entity));
        return ResponseEntity.noContent().build();
    }




    @DeleteMapping("{id}")
    @Operation(summary = "Deletes a movie by their Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity delete(@PathVariable int id){
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("{id}/characters")
    @Operation(summary = "Gets all the characters in a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = FilmCharacterDTO.class)))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity getCharacters(@PathVariable int id){

        return ResponseEntity.ok(filmCharacterMapper.filmCharacterToFilmCharacterDTO(movieService.getCharacters(id)));
    }

    @PutMapping("{id}/characters")
    @Operation(summary = "Updates the characters in a movie byt its ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity updateCharacters(@PathVariable int id,@RequestBody int[] filmCharacterIds){
        movieService.updateCharacters(id,filmCharacterIds);
        return ResponseEntity.noContent().build();
    }
}
