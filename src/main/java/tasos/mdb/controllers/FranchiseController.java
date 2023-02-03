package tasos.mdb.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.mappers.filmCharacters.FilmCharacterMapper;
import tasos.mdb.mappers.franchises.FranchiseMapper;
import tasos.mdb.mappers.franchises.FranchiseMapperImpl;
import tasos.mdb.mappers.movies.MovieMapper;
import tasos.mdb.models.DTO.FilmCharacters.FilmCharacterDTO;
import tasos.mdb.models.DTO.Franchises.FranchiseDTO;
import tasos.mdb.models.DTO.Movies.MovieDTO;
import tasos.mdb.models.Movie;
import tasos.mdb.repositories.FranchiseRepository;
import tasos.mdb.services.character.FilmCharacterService;
import tasos.mdb.services.franchise.FranchiseService;
import tasos.mdb.services.movie.MovieService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/franchises")
public class FranchiseController {


    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    private final FilmCharacterService filmCharacterService;

    private final FilmCharacterMapper filmCharacterMapper;

    private final MovieMapper movieMapper;

    private final MovieService movieService;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper, FilmCharacterService filmCharacterService, FilmCharacterMapper filmCharacterMapper, MovieMapper movieMapper, MovieService movieService) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
        this.filmCharacterService = filmCharacterService;
        this.filmCharacterMapper = filmCharacterMapper;
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
             franchiseMapper.franchiseToFranchiseDTO(franchiseService.findAll())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(franchiseMapper.
                franchiseToFranchiseDTO(
                        franchiseService.findById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity add(@RequestBody FranchiseDTO entity) throws URISyntaxException{

        franchiseService.add(franchiseMapper.franchiseDTOtoFranchise(entity));
        URI uri = new URI("ap1/franchises/"+entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FranchiseDTO entity, @PathVariable int id){
        if(id!= entity.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchiseMapper.franchiseDTOtoFranchise(entity));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}/movies")
    public ResponseEntity updateMovies(@PathVariable int id, @RequestBody int[] movieIds){

        franchiseService.updateMovies(id,movieIds);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}/characters")
    public ResponseEntity getAllFranchiseCharacters(@PathVariable int id){
        //will change
        FranchiseDTO franchiseDTO = franchiseMapper.franchiseToFranchiseDTO(franchiseService.findById(id));
        Set<Integer> movieIds = franchiseDTO.getMovies();
        Set<MovieDTO> movieDTOs = new HashSet<>();
        for(Integer movieId:movieIds){
            movieDTOs.add(movieMapper.movieToMovieDTO(movieService.findById(movieId)));
        }
        Collection<FilmCharacterDTO> allFilmCharactersDTOs = new HashSet<>();
        Collection<Integer> allCharacterIds = new HashSet<>();
        for(MovieDTO movieDTO:movieDTOs){
            allCharacterIds.addAll(movieDTO.getFilmCharacters());
        }
        for(Integer characterId : allCharacterIds){
            allFilmCharactersDTOs.add(filmCharacterMapper.filmCharacterToFilmCharacterDTO(filmCharacterService.findById(characterId)));

        }



        return ResponseEntity.ok(allFilmCharactersDTOs);
    }
}
