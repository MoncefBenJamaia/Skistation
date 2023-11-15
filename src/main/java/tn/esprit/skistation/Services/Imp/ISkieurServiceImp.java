package tn.esprit.skistation.Services.Imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.Entities.*;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Repositories.CoursRepo;
import tn.esprit.skistation.Repositories.InscriptionRepo;
import tn.esprit.skistation.Repositories.PisteRepo;
import tn.esprit.skistation.Repositories.SkieurRepo;
import tn.esprit.skistation.Services.ISkieurService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ISkieurServiceImp implements ISkieurService {


    private final SkieurRepo skieurRepo;

    private final PisteRepo pisteRepo;

    private final CoursRepo coursRepo;

    private final InscriptionRepo inscriptionRepo;
    @Override
    public Skieur addSkieur(Skieur s) {
        return skieurRepo.save(s);
    }

    @Override
    public Skieur updateSkieur(Skieur s) {
        return skieurRepo.save(s);
    }

    @Override
    public List<Skieur> getAll() {
           log.info("in methode !!");
           return (List<Skieur>) skieurRepo.findAll();
    }

    @Override
    public Skieur getID(long id) {
        return skieurRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no Skieur found with this ID"+id));
    }

    @Override
    public boolean deleteByID(long id) {
        skieurRepo.deleteById(id);

        return !(skieurRepo.existsById(id));
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur s, long numC){

        // récupération des objets
        Cours cours = coursRepo.findById(numC).orElseThrow(()-> new ClassCastException("Cours not found"));
        Inscription inscription= s.getInscriptions().stream().findFirst().get();
        //
        inscription.setSkieurs(s);
        inscription.setCours(cours);

        skieurRepo.save(s);
        inscriptionRepo.save(inscription);
        return s ;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepo.findByAbonnementTypeAbonnement(typeAbonnement);
    }

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
  @Override
  public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
      Skieur skieur=skieurRepo.findById(numSkieur).orElse(null);
      Piste piste=pisteRepo.findById(numPiste).orElse(null);
      skieur.getPistes().add(piste);
      return skieurRepo.save(skieur);
  }

  @Override
    public List<Object[]> getSkieurPistesCountJPQL(){
      return skieurRepo.getSkieurPistesCountJPQL();
    }

}
