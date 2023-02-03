package tasos.mdb.repositories;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tasos.mdb.models.FilmCharacter;

import java.util.Set;

public interface FilmCharacterRepository extends JpaRepository<FilmCharacter, Integer> {
    @Query("select c from FilmCharacter c where c.fullName like %?1%")
    Set<FilmCharacter> findAllByName(String name);

    @Query(value = "delete from movies_characters mc where mc.character_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteCharacters(int characterId);


}
