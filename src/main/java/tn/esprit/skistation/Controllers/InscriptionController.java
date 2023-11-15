package tn.esprit.skistation.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.Entities.Inscription;
import tn.esprit.skistation.Entities.Moniteur;
import tn.esprit.skistation.Services.IInscriptionService;
import tn.esprit.skistation.Services.IMoniteurService;

import java.util.List;

@RestController
@RequestMapping("inscription")
@RequiredArgsConstructor
public class InscriptionController {
    private final IInscriptionService iInscriptionService;
    @GetMapping
    public List<Inscription> getAll() {
        return iInscriptionService.getAll();
    }
    @GetMapping("{id}")
    public Inscription getById(@PathVariable long id){
        return iInscriptionService.getID(id);
    }
   @PostMapping
   public Inscription addInscription(@RequestBody Inscription s){ return iInscriptionService.addInscription(s);}
    @PutMapping
    public Inscription updateInscription(@RequestBody Inscription s){
        return iInscriptionService.updateInscription(s);
    }
    @DeleteMapping("{id}")
    public boolean deletInscription (@PathVariable long id){
        return iInscriptionService.deleteByID(id);
    }

    @PostMapping("{idS}")
    public Inscription addRegistrationAndAssignToSkieur(@PathVariable long idS , Inscription i){

        return iInscriptionService.addRegistrationAndAssignToSkieur(idS,i);
    }

    @PostMapping("{numR}/{numC}")
    Inscription assignRegistrationToCourse(@PathVariable Long numR,@PathVariable Long numC){
        return iInscriptionService.assignRegistrationToCourse(numR,numC);
    }
}
