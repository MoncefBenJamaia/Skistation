package tn.esprit.skistation.Services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.Entities.Abonnement;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Repositories.AbonnementRepo;
import tn.esprit.skistation.Services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;
@Service
public class IAbonnementServiceImp implements IAbonnementService {
    @Autowired
    AbonnementRepo abonnementRepo;
    @Override
    public Abonnement addAbonnement(Abonnement a) {
        return abonnementRepo.save(a);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement a) {
        return abonnementRepo.save(a);
    }

    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) abonnementRepo.findAll();
    }

    @Override
    public Abonnement getID(long id) {
        return abonnementRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no course found with this ID"+id));
    }

    @Override
    public boolean deleteByID(long id) {
        abonnementRepo.deleteById(id);

        return !(abonnementRepo.existsById(id));
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate){
       return abonnementRepo. findAbonnementByDateDebutAfterAndDateFinBefore(startDate,endDate);
    }
    @Override
    public List<Abonnement>getAbonnementByType(TypeAbonnement typeAbonnement){
        return  abonnementRepo.findAbonnementByTypeAbonnementOrderByDateDebut(typeAbonnement);
    }
}
