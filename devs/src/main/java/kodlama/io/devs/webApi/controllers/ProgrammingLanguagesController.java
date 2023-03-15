package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

    private final ProgrammingLanguageService plService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService plService) {
        this.plService = plService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return plService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetAllProgrammingLanguagesResponse getById(@PathVariable("id") int id) {
        return plService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        try {
            plService.add(createProgrammingLanguageRequest);
            return ResponseEntity.created(null).body("created");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    void update(@PathVariable("id") int id, @RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        this.plService.update(id,updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
        this.plService.delete (id);
    }
}
