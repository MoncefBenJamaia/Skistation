package tn.esprit.skistation.Repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.skistation.Entities.Inscription;

public interface InscriptionRepo extends CrudRepository<Inscription, Long> {
}
