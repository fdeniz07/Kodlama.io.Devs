package kodlama.io.devs.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.dtos.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.dtos.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.dtos.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.dtos.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {

    private final TechnologyService technologyService;

//    @Autowired
//    public TechnologiesController(TechnologyService technologyService) {
//        this.technologyService = technologyService;
//    }

    @GetMapping()
    public List<GetAllTechnologiesResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdTechnologyResponse getById(@PathVariable @RequestParam(name = "id") int id) {
        return technologyService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateTechnologyRequest createTechnologyRequest){
//        try {
//            technologyService.add(createTechnologyRequest);
//            return ResponseEntity.created(null).body("created");
//        } catch (Exception exception) {
//            return ResponseEntity.badRequest().body(exception.getMessage());
//        }
        this.technologyService.add(createTechnologyRequest);
    }

    @PutMapping()
    void update(@RequestBody @Valid() UpdateTechnologyRequest updateTechnologyRequest)  {
        this.technologyService.update( updateTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    void delete(@RequestParam(name = "id") int id) {
        this.technologyService.delete(id);
    }
}
