package tasos.ass_3.services.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import tasos.ass_3.exceptions.MovieNotFoundException;

import tasos.ass_3.models.Movie;

import tasos.ass_3.repositories.MovieRepository;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
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
}
