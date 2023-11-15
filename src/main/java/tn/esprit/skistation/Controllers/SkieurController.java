package tn.esprit.skistation.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.Entities.Enums.TypeAbonnement;
import tn.esprit.skistation.Entities.Piste;
import tn.esprit.skistation.Entities.Skieur;
import tn.esprit.skistation.Services.ISkieurService;

import java.util.List;

@RestController
@RequestMapping("skieur")
@RequiredArgsConstructor // or Autowired
public class SkieurController {
    private final ISkieurService iSkieurService;
    /*@GetMapping
    public List<Skieur> getAll() {
        return iSkieurService.getAll();
    }*/
    /*@GetMapping("{id}")
    public Skieur getById(@PathVariable long id){
        return iSkieurService.getID(id);
    }*/
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur s){
        return iSkieurService.addSkieur(s);
    }
    @PutMapping
    public Skieur updateskieur(@RequestBody Skieur s){
        return iSkieurService.updateSkieur(s);
    }
    @DeleteMapping("{id}")
    public boolean deletUser (@PathVariable long id){
        return iSkieurService.deleteByID(id);
   }


    @PostMapping(value = "{numC}")
    Skieur addSkierAndAssignToCourse(@RequestBody Skieur s, @PathVariable long numC){
        return iSkieurService.addSkierAndAssignToCourse(s,numC);
    }
    @GetMapping("{typeAbonnement}")
    List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement){
        return iSkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
    @PostMapping(value = "{numSkieur}/{numPiste}")
    Skieur assignSkierToPiste(@PathVariable long numSkieur , @PathVariable long numPiste) {
        return iSkieurService.assignSkierToPiste(numSkieur,numPiste);
    }

    @GetMapping
    Object getSkieurPistesCountJPQL(){return iSkieurService.getSkieurPistesCountJPQL();}
}