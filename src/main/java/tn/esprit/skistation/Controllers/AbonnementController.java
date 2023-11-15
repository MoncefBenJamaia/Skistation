package tn.esprit.skistation.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.Entities.Abonnement;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Services.IAbonnementService;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("abonnement")
@RequiredArgsConstructor
public class AbonnementController {
    private final IAbonnementService iAbonnementSevice;

    @GetMapping
    public List<Abonnement> getAll() {
        return iAbonnementSevice.getAll();
    }

    /*@GetMapping(value = "{id}")
    public Abonnement getById(@PathVariable Long id) {
        return iAbonnementSevice.getID(id);
    }*/

    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement)
    {
        return iAbonnementSevice.addAbonnement(abonnement);

    }

    @PutMapping
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement)
    {
        return iAbonnementSevice.updateAbonnement(abonnement);

    }

    @DeleteMapping(value = "{id}")
    public Boolean deleteById(@PathVariable Long id)
    {
        return iAbonnementSevice.deleteByID(id);

    }
    @GetMapping("{startDate}/{endDate}")
    public List<Abonnement> retrieveSubscriptionsByDates(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate){
        return iAbonnementSevice.retrieveSubscriptionsByDates(startDate,endDate);
    }

    @GetMapping("{typeAbonnement}")
    public List<Abonnement> getAbonnementByType(@PathVariable TypeAbonnement typeAbonnement){
        return  iAbonnementSevice.getAbonnementByType(typeAbonnement);
    }
}
