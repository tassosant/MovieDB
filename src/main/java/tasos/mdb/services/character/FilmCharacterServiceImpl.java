package tasos.mdb.services.character;

import org.springframework.stereotype.Service;
import tasos.mdb.exceptions.MovieCharacterNotFoundException;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.repositories.FilmCharacterRepository;

import java.util.Collection;
@Service
public class FilmCharacterServiceImpl implements FilmCharacterService {
    private final FilmCharacterRepository filmCharacterRepository;

    public FilmCharacterServiceImpl(FilmCharacterRepository filmCharacterRepository) {
        this.filmCharacterRepository = filmCharacterRepository;
    }


    @Override
    public Collection<FilmCharacter> findAllByName(String name){
        return filmCharacterRepository.findAllByName(name);
    }

    @Override
    public FilmCharacter findById(Integer id){
        return filmCharacterRepository.findById(id).orElseThrow(
                () -> new MovieCharacterNotFoundException(id));
    }


    @Override
    public Collection<FilmCharacter> findAll(){
        return filmCharacterRepository.findAll();
    }

    @Override
    public FilmCharacter add(FilmCharacter entity){
        return filmCharacterRepository.save(entity);
    }

    @Override
    public FilmCharacter update(FilmCharacter entity){
        return filmCharacterRepository.save(entity);
    }
    @Override
    public void deleteById(Integer id){
        deleteCharacters(id);
        filmCharacterRepository.deleteById(id);
    }

    @Override
    public void deleteCharacters(int characterId){
        filmCharacterRepository.deleteCharacters(characterId);
    }

    @Override
    public boolean exists(Integer id){
        return filmCharacterRepository.existsById(id);
    }



}
