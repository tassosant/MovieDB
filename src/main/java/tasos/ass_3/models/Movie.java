package tasos.ass_3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

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
    @Nationalized
    private String title;
    @Column(length = 40)
    private String genre;
    @Column(name="release_year")
    private int year;
    @Column(length = 30)
    @Nationalized
    private String director;

    @Nationalized
    private String picture;

    @Nationalized
    private String trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name= "character_id")}
    )
    private Set<Character> characters;
}
