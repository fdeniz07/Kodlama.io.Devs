package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.dtos.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.dtos.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.dtos.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.dtos.responses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguagesResponse> getAll();

    GetByIdProgrammingLanguageResponse getById(int id);

    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

    void delete(int id);

    //void isNameEmpty(ProgrammingLanguage programmingLanguage) throws Exception;

    //void isNameAlreadyExist(ProgrammingLanguage programmingLanguage) throws Exception;
}
