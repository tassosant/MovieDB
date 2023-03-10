package tasos.mdb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private int id;
    @Column(name = "franchise_name", length = 40, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
