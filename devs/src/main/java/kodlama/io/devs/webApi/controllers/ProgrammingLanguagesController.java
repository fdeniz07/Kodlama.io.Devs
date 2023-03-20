package kodlama.io.devs.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.dtos.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.dtos.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.dtos.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.dtos.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
@AllArgsConstructor
public class ProgrammingLanguagesController {

    private final ProgrammingLanguageService plService;

//    @Autowired
//    public ProgrammingLanguagesController(ProgrammingLanguageService plService) {
//        this.plService = plService;
//    }

    @GetMapping()
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        return plService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguageResponse getById(@PathVariable @RequestParam(name = "id") int id) {
        return plService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
//        try {
//            plService.add(createProgrammingLanguageRequest);
//            return ResponseEntity.created(null).body("created");
//        } catch (Exception exception) {
//            return ResponseEntity.badRequest().body(exception.getMessage());
//        }
        this.plService.add(createProgrammingLanguageRequest);
    }

    @PutMapping()
    public void update(@RequestBody() @Valid() UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        this.plService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam(name = "id") int id) {
        this.plService.delete (id);
    }
}
