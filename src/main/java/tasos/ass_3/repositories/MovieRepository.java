package tasos.ass_3.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tasos.ass_3.models.Movie;

import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //I will test it if it is correct without the alias
    @Query("Select m from Movie m where m.title like %?1%")
    Set<Movie> findAllByName(String name);
}
