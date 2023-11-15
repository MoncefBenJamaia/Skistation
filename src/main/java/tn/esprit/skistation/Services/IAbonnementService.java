package tn.esprit.skistation.Services;

import tn.esprit.skistation.Entities.Abonnement;
import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface IAbonnementService {
    Abonnement addAbonnement(Abonnement a);
    Abonnement updateAbonnement(Abonnement a);

    List<Abonnement> getAll();

    Abonnement getID(long id);

    boolean deleteByID (long id);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

    List<Abonnement>getAbonnementByType(TypeAbonnement typeAbonnement);
}
