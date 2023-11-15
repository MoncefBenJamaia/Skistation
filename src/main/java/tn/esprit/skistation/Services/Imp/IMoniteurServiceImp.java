package tn.esprit.skistation.Services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Entities.Moniteur;
import tn.esprit.skistation.Entities.Skieur;
import tn.esprit.skistation.Repositories.CoursRepo;
import tn.esprit.skistation.Repositories.MoniteurRepo;
import tn.esprit.skistation.Services.IMoniteurService;

import java.util.*;

@Service
public class IMoniteurServiceImp implements IMoniteurService {
    @Autowired
    MoniteurRepo moniteurRepo;
    @Autowired
    CoursRepo coursRepo;

    @Override
    public Moniteur addMoniteur(Moniteur m) {
        return moniteurRepo.save(m);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur m) {
        return moniteurRepo.save(m);
    }

    @Override
    public List<Moniteur> getAll() {
        return (List<Moniteur>) moniteurRepo.findAll();
    }

    @Override
    public Moniteur getID(long id) {
        return moniteurRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("no course found with this ID" + id));
    }

    @Override
    public boolean deleteByID(long id) {
        moniteurRepo.deleteById(id);

        return !(moniteurRepo.existsById(id));
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numC) {
        Cours cours = coursRepo.findById(numC).orElse(null);
        Set<Cours> SetCours= new HashSet<>();
        SetCours.add(cours);
        moniteur.setCours(SetCours);
        return moniteurRepo.save(moniteur);

    }


}
