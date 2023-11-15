package tn.esprit.skistation.Repositories;

import jakarta.validation.constraints.Past;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.skistation.Entities.Cours;

import java.util.List;

public interface CoursRepo  extends CrudRepository<Cours, Long> {


    @Query(value = "SELECT * FROM cours c \n" +
            "JOIN moniteur_cours mc ON c.num_cours=mc.cours_num_cours \n" +
            "JOIN moniteur m ON m.num_moniteur= mc.moniteur_num_moniteur \n" +
            "WHERE m.nom_m = :nomM", nativeQuery = true)
    List<Cours> getcoursByMoniteurNameSql( @Param("nomM") String nomM );

    @Query( "SELECT c FROM Cours c \n" +
            "JOIN Moniteur m ON c member m.cours \n" +
            "WHERE m.nom_M = :nomM")
    List<Cours> getcoursByMoniteurNameJpql( @Param("nomM") String nomM );
}