package tasos.ass_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tasos.ass_3.models.FilmCharacter;

import java.util.Set;

public interface MovieCharacterRepository extends JpaRepository<FilmCharacter, Integer> {
    @Query("select mc from FilmCharacter mc where mc.fullName like %?1%")
    Set<FilmCharacter> findAllByName(String name);
}
