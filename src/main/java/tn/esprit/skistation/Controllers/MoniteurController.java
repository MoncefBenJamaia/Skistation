package tn.esprit.skistation.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.Entities.Moniteur;
import tn.esprit.skistation.Entities.Skieur;
import tn.esprit.skistation.Services.IMoniteurService;

import java.util.List;


@RestController
@RequestMapping("moniteur")
@RequiredArgsConstructor // or Autowired
public class MoniteurController {
    private final IMoniteurService iMoniteurService;
    @GetMapping
    public List<Moniteur> getAll() {
        return iMoniteurService.getAll();
    }
    @GetMapping("{id}")
    public Moniteur getById(@PathVariable long id){
        return iMoniteurService.getID(id);
    }
    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur m){
        return iMoniteurService.addMoniteur(m);
    }
    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur m){
        return iMoniteurService.updateMoniteur(m);
    }
    @DeleteMapping("{id}")
    public boolean deletMoniteur (@PathVariable long id){
        return iMoniteurService.deleteByID(id);
    }
    @PostMapping("{numC}")
    public Moniteur addInstructorAndAssignToCourse (@RequestBody Moniteur m , @PathVariable long numC){
        return iMoniteurService.addInstructorAndAssignToCourse(m,numC);
    }

}
