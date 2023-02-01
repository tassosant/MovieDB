package tasos.ass_3.services.character;

import org.springframework.stereotype.Service;
import tasos.ass_3.exceptions.MovieCharacterNotFoundException;
import tasos.ass_3.models.FilmCharacter;
import tasos.ass_3.repositories.MovieCharacterRepository;

import java.util.Collection;
@Service
public class MovieCharacterServiceImpl implements MovieCharacterService{
    private final MovieCharacterRepository movieCharacterRepository;

    public MovieCharacterServiceImpl(MovieCharacterRepository movieCharacterRepository) {
        this.movieCharacterRepository = movieCharacterRepository;
    }


    @Override
    public Collection<FilmCharacter> findAllByName(String name){
        return movieCharacterRepository.findAllByName(name);
    }

    @Override
    public FilmCharacter findById(Integer id){
        return movieCharacterRepository.findById(id).orElseThrow(
                () -> new MovieCharacterNotFoundException(id));
    }


    @Override
    public Collection<FilmCharacter> findAll(){
        return movieCharacterRepository.findAll();
    }

    @Override
    public FilmCharacter add(FilmCharacter entity){
        return movieCharacterRepository.save(entity);
    }

    @Override
    public FilmCharacter update(FilmCharacter entity){
        return movieCharacterRepository.save(entity);
    }
    @Override
    public void deleteById(Integer id){
        movieCharacterRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id){
        return movieCharacterRepository.existsById(id);
    }



}
