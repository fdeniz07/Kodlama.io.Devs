package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.dtos.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.dtos.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.dtos.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.dtos.responses.GetByIdTechnologyResponse;

import java.util.List;

public interface TechnologyService {

    List<GetAllTechnologiesResponse> getAll();

    GetByIdTechnologyResponse getById(int id);

    void add(CreateTechnologyRequest createTechnologyRequest);

    void update(UpdateTechnologyRequest updateTechnologyRequest);

    void delete(int id);

    //void isNameEmpty(Technology technology) throws Exception;

    //void isNameAlreadyExist(Technology technology) throws Exception;
}
