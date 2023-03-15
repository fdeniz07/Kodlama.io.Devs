package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    List<GetAllProgrammingLanguagesResponse> getAll();
    GetAllProgrammingLanguagesResponse getById(int id);
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;

    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception;

    void isNameEmpty(ProgrammingLanguage programmingLanguage) throws Exception;

    void isNameAlreadyExist(ProgrammingLanguage programmingLanguage) throws Exception;
}
