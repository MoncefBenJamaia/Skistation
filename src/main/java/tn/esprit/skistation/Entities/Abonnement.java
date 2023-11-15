package tn.esprit.skistation.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.skistation.Entities.Enums.Couleur;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long numAbon ;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Float prixAbon;

    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbonnement;

    @OneToOne
    Skieur skieur;
}
