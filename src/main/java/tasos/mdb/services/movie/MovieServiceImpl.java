package tasos.mdb.services.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import tasos.mdb.exceptions.MovieNotFoundException;

import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Movie;

import tasos.mdb.repositories.FilmCharacterRepository;
import tasos.mdb.repositories.MovieRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    private final MovieRepository movieRepository;
    private final FilmCharacterRepository filmCharacterRepository;

    public MovieServiceImpl(MovieRepository movieRepository, FilmCharacterRepository filmCharacterRepository) {
        this.movieRepository = movieRepository;
        this.filmCharacterRepository = filmCharacterRepository;
    }

    @Override
    public Collection<Movie> findAllByName(String name){
        return movieRepository.findAllByName(name);
    }

    @Override
    public Movie findById(Integer id){
        return movieRepository.findById(id).orElseThrow(
                ()->new MovieNotFoundException(id)
        );
    }

    @Override
    public Collection<Movie> findAll(){
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity){
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity){
        return movieRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id){
        movieRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id){
        return movieRepository.existsById(id);
    }

    @Override
    public Collection<FilmCharacter> getCharacters(int movieId){
        return movieRepository.findById(movieId).get().getFilmCharacters();
    }
    @Override
    public void updateCharacters(int movieId, int[] filmCharacters){
        //the get() method returns the value if present else throws Exception
        Movie movie = movieRepository.findById(movieId).get();
        Set<FilmCharacter> filmCharacterSet = new HashSet<>();
        //Iterate through integer array filmCharacters
        for(int id : filmCharacters){
            filmCharacterSet.add(filmCharacterRepository.findById(id).get());

        }
        movie.setFilmCharacters(filmCharacterSet);
        movieRepository.save(movie);
    }

    @Override
    public int updateById(int franchiseId,int movieId){
        return 0;

    }

}
