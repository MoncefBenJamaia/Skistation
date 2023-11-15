package tn.esprit.skistation.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.skistation.Entities.Enums.Couleur;
import tn.esprit.skistation.Entities.Enums.Support;
import tn.esprit.skistation.Entities.Enums.TypeCours;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    private  long numCours;

    private int niveau;

    @Enumerated(EnumType.STRING)
    TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    Support support;

    private float prix;

    private int creneau;

    @OneToMany (mappedBy = "cours")
    @JsonIgnore
    Set<Inscription> inscriptions;


}
