package tn.esprit.skistation.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.skistation.Entities.Abonnement;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Entities.Skieur;

import java.time.LocalDate;
import java.util.List;


public interface AbonnementRepo extends CrudRepository<Abonnement, Long> {
    List<Abonnement> findAbonnementByDateDebutAfterAndDateFinBefore(LocalDate dateDebut,LocalDate dateFin);
    List<Abonnement> findAbonnementByTypeAbonnementOrderByDateDebut(TypeAbonnement typeAbonnement);


}
