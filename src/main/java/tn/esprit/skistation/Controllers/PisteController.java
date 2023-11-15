package tn.esprit.skistation.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.Entities.Piste;
import tn.esprit.skistation.Services.IPisteService;


import java.util.List;

@RestController
@RequestMapping("piste")
@RequiredArgsConstructor
public class PisteController {
    private final IPisteService iPisteService;


    @GetMapping
    public List<Piste> getAll() {
        return iPisteService.getAll();
    }

    @GetMapping(value = "{id}")
    public Piste getById(@PathVariable Long id) {
        return iPisteService.getID(id);
    }

    @PostMapping
    public Piste addPiste(@RequestBody Piste piste)
    {
        return iPisteService.addPiste(piste);

    }

    @PutMapping
    public Piste updatePiste(@RequestBody Piste piste)
    {
        return iPisteService.updatePiste(piste);

    }

    @DeleteMapping(value = "{id}")
    public Boolean deleteById(@PathVariable Long id)
    {
        return iPisteService.deleteByID(id);

    }



}
