package tn.esprit.skistation.Services;

import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Entities.Skieur;

import java.util.List;

public interface ISkieurService {

    Skieur addSkieur(Skieur s);
    Skieur updateSkieur(Skieur s);

    List<Skieur> getAll();

    Skieur getID(long id);

    boolean deleteByID (long id);


    Skieur addSkierAndAssignToCourse(Skieur s, long numC);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);

    /*  {

              "nomS": "string",
                  "prenomS": "string",
                  "dateNaissance": "2023-10-26",
                  "ville": "string",

                  "abonnement": {
              "dateDebut": "2023-10-26",
                      "dateFin": "2023-10-26",
                      "prixAbon": 0,
                      "typeAbonnement": "ANNUEL"
          },
              "inscriptions": [
              {
                  "numSemaine": 0
              }
        ]

          }*/
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    List<Object[]> getSkieurPistesCountJPQL();
}
