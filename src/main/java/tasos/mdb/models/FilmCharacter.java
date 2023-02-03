package tasos.mdb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
//We modified the table's name because character is keyword in postgres,so to avoid conflicts
//Also, if we declare the class as "Character" there will be conflict with java's data type "char".
@Table(name = "film_characters")
public class FilmCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    @Column(name = "character_full_name", length = 60,nullable = false)
    private String fullName;

    @Column(name = "character_alias", length = 20)
    private String alias;

    @Column(length = 12)
    //@Enumerated(EnumType.STRING)
    private String gender;

    @ManyToMany(mappedBy = "filmCharacters")
    private Set<Movie> movies;

}
