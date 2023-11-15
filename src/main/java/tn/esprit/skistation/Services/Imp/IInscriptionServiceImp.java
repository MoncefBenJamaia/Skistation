package tn.esprit.skistation.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Entities.Inscription;
import tn.esprit.skistation.Entities.Skieur;
import tn.esprit.skistation.Repositories.CoursRepo;
import tn.esprit.skistation.Repositories.InscriptionRepo;
import tn.esprit.skistation.Repositories.SkieurRepo;
import tn.esprit.skistation.Services.IInscriptionService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IInscriptionServiceImp implements IInscriptionService {
    private  final InscriptionRepo inscriptionRepo;
    private  final SkieurRepo skieurRepo;
    private final CoursRepo  coursRepo;
    @Override
    public Inscription addInscription(Inscription i) {
        return inscriptionRepo.save(i);
    }

    @Override
    public Inscription updateInscription(Inscription i) {
        return inscriptionRepo.save(i);
    }

    @Override
    public List<Inscription> getAll() {
        return (List<Inscription>) inscriptionRepo.findAll();
    }

    @Override
    public Inscription getID(long id) {
        return inscriptionRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no course found with this ID"+id));
    }

    @Override
    public boolean deleteByID(long id) {
        inscriptionRepo.deleteById(id);

        return !(inscriptionRepo.existsById(id));
    }
    @Override
    public Inscription addRegistrationAndAssignToSkieur(long idS, Inscription i) {
        Skieur skieur = skieurRepo.findById(idS).orElse(null);
        i.setSkieurs(skieur);
        return inscriptionRepo.save(i);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Cours cours=coursRepo.findById(numCourse).orElse(null);
        Inscription inscription=inscriptionRepo.findById(numRegistration).orElse(null);
        inscription.setCours(cours);
        return inscriptionRepo.save(inscription);

    }
}
