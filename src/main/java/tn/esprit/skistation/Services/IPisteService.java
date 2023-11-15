package tn.esprit.skistation.Services;

import tn.esprit.skistation.Entities.Piste;

import java.util.List;

public interface IPisteService {
    Piste addPiste(Piste p);
    Piste updatePiste(Piste p);

    List<Piste> getAll();

    Piste getID(long id);

    boolean deleteByID (long id);


}
