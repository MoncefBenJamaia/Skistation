package tn.esprit.skistation.Services;

import tn.esprit.skistation.Entities.Cours;

import java.util.List;

public interface ICoursService {

    Cours addCours(Cours cours);
    Cours updateCours(Cours cours);

    List<Cours> getAll();

    Cours getID(long id);

    boolean deleteByID (long id);


}
