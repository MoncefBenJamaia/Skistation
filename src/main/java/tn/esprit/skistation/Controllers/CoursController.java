package tn.esprit.skistation.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.Entities.Cours;
import tn.esprit.skistation.Services.ICoursService;
import java.util.List;

@RestController
@RequestMapping("cours")
@RequiredArgsConstructor
public class CoursController {
    private final ICoursService iCoursService;
    @GetMapping
    public List<Cours> getAll() {
        return iCoursService.getAll();
    }
    @GetMapping("{id}")
    public Cours getById(@PathVariable long id){
        return iCoursService.getID(id);
    }
    @PostMapping
    public Cours addCours(@RequestBody Cours s){
        return iCoursService.addCours(s);
    }
    @PutMapping
    public Cours updateCours(@RequestBody Cours s){
        return iCoursService.updateCours(s);
    }
    @DeleteMapping("{id}")
    public boolean deletCours (@PathVariable long id){
        return iCoursService.deleteByID(id);
    }


}
