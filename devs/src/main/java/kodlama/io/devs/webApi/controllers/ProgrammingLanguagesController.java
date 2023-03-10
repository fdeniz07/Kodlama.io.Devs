package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService plService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService plService) {
        this.plService = plService;
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll() {
        return plService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public ProgrammingLanguage getById(@PathVariable("id") int id) {
        return plService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        try {
            plService.add(programmingLanguage);
            return ResponseEntity.created(null).body("created");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProgrammingLanguage> update(@PathVariable("id") int id, @RequestBody ProgrammingLanguage newProgrammingLanguage) throws Exception {
        try {
            return ResponseEntity.ok(plService.update(id, newProgrammingLanguage));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {plService.delete(id);}
}
