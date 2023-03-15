package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.core.enums.LanguageMessageEnum;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository pLRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository pLRepository) {
        this.pLRepository = pLRepository;
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {

        List<ProgrammingLanguage> programmingLanguages = pLRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {

            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());

            programmingLanguagesResponses.add(responseItem);

        }

        return programmingLanguagesResponses;
    }

    @Override
    public GetAllProgrammingLanguagesResponse getById(int id) {

      GetAllProgrammingLanguagesResponse programmingLanguagesResponse = new GetAllProgrammingLanguagesResponse();
      ProgrammingLanguage programmingLanguage = pLRepository.findById(id).orElseThrow();
      programmingLanguagesResponse.setName(programmingLanguage.getName());

      return programmingLanguagesResponse;
    }


    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(createProgrammingLanguageRequest.getName());
        this.isNameEmpty(programmingLanguage);
        this.isNameAlreadyExist(programmingLanguage);
        pLRepository.save(programmingLanguage);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
        this.isNameEmpty(programmingLanguage);
        this.isNameAlreadyExist(programmingLanguage);
        pLRepository.save(programmingLanguage);

    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(deleteProgrammingLanguageRequest.getName());
        this.isNameEmpty(programmingLanguage);
        this.isNameAlreadyExist(programmingLanguage);
        pLRepository.save(programmingLanguage);
    }

    @Override
    public void isNameEmpty(ProgrammingLanguage programmingLanguage) throws Exception {
        if (programmingLanguage.getName().trim().isEmpty() || programmingLanguage.getName().isBlank()) {

            throw new Exception(LanguageMessageEnum.NOTNULL.getMessage());
        }
    }

    @Override
    public void isNameAlreadyExist(ProgrammingLanguage programmingLanguage) throws Exception {
        List<ProgrammingLanguage> languageList = pLRepository.findAll();

        for (ProgrammingLanguage pl : languageList) {
            if (pl.getName().equalsIgnoreCase((programmingLanguage.getName()))) {

                throw new Exception(LanguageMessageEnum.ALREADYEXIST.getMessage());
            }
        }
    }
}
