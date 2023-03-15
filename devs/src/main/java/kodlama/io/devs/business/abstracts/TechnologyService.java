package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.entities.concretes.Technology;

import java.util.List;

public interface TechnologyService {

    List<GetAllTechnologiesResponse> getAll();

    GetAllTechnologiesResponse getById(int id);

    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;

    void update(int technologyId,UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

    void delete(int technologyId,DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;

    void isNameEmpty(Technology technology) throws Exception;

    void isNameAlreadyExist(Technology technology) throws Exception;
}
