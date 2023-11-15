package tn.esprit.skistation.Services.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.Entities.Piste;
import tn.esprit.skistation.Entities.Skieur;
import tn.esprit.skistation.Repositories.PisteRepo;
import tn.esprit.skistation.Repositories.SkieurRepo;
import tn.esprit.skistation.Services.IPisteService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IPisteServiceImp implements IPisteService {
    private final SkieurRepo skieurRepo;

    private final PisteRepo pisteRepo;
    @Override
    public Piste addPiste(Piste p) {
        return pisteRepo.save(p);
    }

    @Override
    public Piste updatePiste(Piste p) {
        return pisteRepo.save(p);
    }

    @Override
    public List<Piste> getAll() {
        return (List<Piste>) pisteRepo.findAll();
    }

    @Override
    public Piste getID(long id) {
        return pisteRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no course found with this ID"+id));
    }

    @Override
    public boolean deleteByID(long id) {
        pisteRepo.deleteById(id);

        return !(pisteRepo.existsById(id));
    }


}
