package tasos.mdb.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tasos.mdb.models.Movie;

import java.util.Set;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //I will test it if it is correct without the alias
    @Query("Select m from Movie m where m.title like %?1%")
    Set<Movie> findAllByName(String name);

   /* @Query("select m from Movie m where m.id=?1")
    Movie findById(int id);*/

    @Query("UPDATE Movie m\n" +
            "SET m.franchise.id = ?1\n" +
            "WHERE m.id =?2")
    @Modifying
    int updateById(int franchiseId,int movieId);




}
