package tasos.mdb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.mappers.filmCharacters.FilmCharacterMapper;
import tasos.mdb.models.DTO.FilmCharacters.FilmCharacterDTO;
import tasos.mdb.services.character.FilmCharacterService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/characters")
public class FilmCharacterController {
    private final FilmCharacterService filmCharacterService;
    private final FilmCharacterMapper filmCharacterMapper;

    public FilmCharacterController(FilmCharacterService filmCharacterService, FilmCharacterMapper filmCharacterMapper) {
        this.filmCharacterService = filmCharacterService;
        this.filmCharacterMapper = filmCharacterMapper;
    }


    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                filmCharacterMapper.filmCharacterToFilmCharacterDTO(
                        filmCharacterService.findAll())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(filmCharacterMapper
                .filmCharacterToFilmCharacterDTO(
                        filmCharacterService.findById(id)));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody FilmCharacterDTO entity) throws URISyntaxException{
        filmCharacterService.add(filmCharacterMapper.filmCharacterDTOtoFilmCharacter(entity));
        URI uri = new URI("api/v1/characters/"+entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FilmCharacterDTO entity,@PathVariable int id){
        if(id!= entity.getId())
            return ResponseEntity.badRequest().build();
        filmCharacterService.update(
                filmCharacterMapper.filmCharacterDTOtoFilmCharacter(entity)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        filmCharacterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
