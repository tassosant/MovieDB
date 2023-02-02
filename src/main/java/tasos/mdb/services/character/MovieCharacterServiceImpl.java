package tasos.mdb.services.character;

import org.springframework.stereotype.Service;
import tasos.mdb.exceptions.MovieCharacterNotFoundException;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.repositories.FilmCharacterRepository;

import java.util.Collection;
@Service
public class MovieCharacterServiceImpl implements MovieCharacterService{
    private final FilmCharacterRepository filmCharacterRepository;

    public MovieCharacterServiceImpl(FilmCharacterRepository filmCharacterRepository) {
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
        filmCharacterRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id){
        return filmCharacterRepository.existsById(id);
    }



}
