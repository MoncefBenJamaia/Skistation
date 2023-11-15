package tn.esprit.skistation.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.skistation.Entities.Abonnement;
import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Entities.Enums.Couleur;
import tn.esprit.skistation.Entities.Enums.Support;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Entities.Enums.TypeCours;
import tn.esprit.skistation.Entities.Skieur;

import java.util.List;

public interface SkieurRepo extends CrudRepository<Skieur, Long> {
    List<Skieur> findByAbonnementTypeAbonnement(TypeAbonnement  typeAbonnement);
   //List<Skieur> findByAbonnementTypeAbonnementAndPistesCouleurAndInscriptionsCoursTypeCoursAndInscriptionsCoursSupport(TypeAbonnement abonnement_typeAbonnement, Couleur pistes_couleur, TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support);


    /* "    @Query(value = "SELECT *\n" +
            "FROM skieur s \n" +
            "JOIN inscription i ON s.num_skieur=i.skieurs_num_skieur\n" +
            "JOIN moniteur_cours mc ON i.cours_num_cours=mc.cours_num_cours \n" +
            "JOIN moniteur m ON m.num_moniteur= mc.moniteur_num_moniteur\n" +
            "WHERE m.nom_m = :nomM" , nativeQuery = true)
    List<Cours> getcoursByMoniteurNameSql( @Param("nomM") String nomM );*/

//Order By nombre pistes des skieur ???
    @Query("SELECT s FROM Skieur s \n" +
           "JOIN Inscription i ON s = i.skieurs \n" +
            " JOIN Moniteur m ON i.cours member m.cours "+
           "WHERE m.nom_M = :nomM ")
   List<Skieur> getSkieurByMoniteurNameJpql( @Param("nomM") String nomM );
    @Query(value = "SELECT s.nom_s, COUNT(sp.pistes_num_piste) AS num_pistes " +
            "FROM skieur_pistes sp " +
            "JOIN skieur s ON sp.skieurs_num_skieur = s.num_skieur " +
            "GROUP BY sp.skieurs_num_skieur " +
            "ORDER BY num_pistes DESC", nativeQuery = true)
    List<Object[]> getSkieurPistesCount();

    @Query(value = "SELECT s " +
            "FROM Skieur s  " +
            "ORDER BY SIZE(s.pistes) DESC")
    List<Object[]> getSkieurPistesCountJPQL();



}
