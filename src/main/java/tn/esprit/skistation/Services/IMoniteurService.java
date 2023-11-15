package tn.esprit.skistation.Services;

import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Entities.Moniteur;

import java.util.List;

public interface IMoniteurService {

    Moniteur addMoniteur(Moniteur m);
    Moniteur updateMoniteur(Moniteur m);

    List<Moniteur> getAll();

    Moniteur getID(long id);

    boolean deleteByID (long id);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numC);
}
