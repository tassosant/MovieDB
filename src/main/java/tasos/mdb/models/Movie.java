package tasos.mdb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name= "movie_title", length = 60, nullable = false)
    private String title;
    @Column(length = 40)
    private String genre;
    @Column(name="release_year")
    private int year;
    @Column(length = 30)
    private String director;


    private String picture;

    private String trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;
    @ManyToMany
    @JoinTable(
            name = "movies_characters",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name= "character_id")}
    )
    private Set<FilmCharacter> filmCharacters;
}
