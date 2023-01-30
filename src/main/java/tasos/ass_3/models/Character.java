package tasos.ass_3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.Set;


@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    @Column(name = "character_full_name", length = 60,nullable = false)
    @Nationalized
    private String fullName;

    @Column(name = "character_alias", length = 20)
    @Nationalized
    private String alias;

    @Column(length = 12)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
