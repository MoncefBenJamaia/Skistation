package tn.esprit.skistation.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int numSkieur;


    @ManyToMany
    @JsonIgnore
    Set<Piste> pistes;


    @OneToMany (mappedBy = "skieurs")
    Set<Inscription> inscriptions;

    private String nom_S;

    private String prenom_S;

    private String ville;

    private LocalDate dateDeNaissance ;

    @OneToOne (cascade = CascadeType.ALL)
    Abonnement abonnement;

}
