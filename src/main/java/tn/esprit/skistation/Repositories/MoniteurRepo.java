package tn.esprit.skistation.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.skistation.Entities.Moniteur;

public interface MoniteurRepo extends CrudRepository<Moniteur, Long> {
}
