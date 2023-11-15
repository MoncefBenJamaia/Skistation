package tn.esprit.skistation.Services;


import tn.esprit.skistation.Entities.Inscription;

import java.util.List;

public interface IInscriptionService {
    Inscription addInscription(Inscription i);
    Inscription updateInscription(Inscription i );

    List<Inscription> getAll();

    Inscription getID(long id);

    boolean deleteByID (long id);

    Inscription addRegistrationAndAssignToSkieur(long idS, Inscription i);

    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);
}
