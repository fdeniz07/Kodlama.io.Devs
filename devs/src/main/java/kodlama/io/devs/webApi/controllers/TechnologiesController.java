package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologiesResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetAllTechnologiesResponse getById(@PathVariable("id") int id) {
        return technologyService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        try {
            technologyService.add(createTechnologyRequest);
            return ResponseEntity.created(null).body("created");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    void update(@PathVariable("id") int id, @RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        this.technologyService.update(id, updateTechnologyRequest);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") int id, @RequestBody DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        this.technologyService.delete(id, deleteTechnologyRequest);
    }
}
