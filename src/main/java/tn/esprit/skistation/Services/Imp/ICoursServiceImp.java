package tn.esprit.skistation.Services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Repositories.CoursRepo;
import tn.esprit.skistation.Services.ICoursService;

import java.util.List;


@Service
public class ICoursServiceImp implements ICoursService {

    @Autowired
    CoursRepo coursRepo ;
    @Override
    public Cours addCours(Cours c) {
      return coursRepo.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return coursRepo.save(c);
    }

    @Override
    public List<Cours> getAll() {
        return (List<Cours>) coursRepo.findAll();
    }

    @Override
    public Cours getID(long id) {
        return coursRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("no course found with this ID"+id));
        //oursRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteByID(long id) {

        coursRepo.deleteById(id);

        return !(coursRepo.existsById(id));
    }
}
