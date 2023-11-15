package tn.esprit.skistation.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.skistation.Entities.Enums.Couleur;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long numPiste;

    private String nomPiste;

    private  int longeur;

    private  int pente;
    @Enumerated(EnumType.STRING)
    Couleur couleur;

    @ManyToMany (mappedBy = "pistes")
    Set<Skieur> skieurs;

}
