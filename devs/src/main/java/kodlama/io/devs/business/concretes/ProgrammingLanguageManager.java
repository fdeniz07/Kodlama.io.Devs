package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.core.utilities.enums.LanguageMessageEnum;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository pLRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository pLRepository) {
        this.pLRepository = pLRepository;
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {

        List<ProgrammingLanguage> programmingLanguages = pLRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<>();

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
    public void update(int programmingLanguageId, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {

        ProgrammingLanguage programmingLanguage = pLRepository.findById(programmingLanguageId).orElseThrow(() -> new Exception("There is no language for this id:" + programmingLanguageId));
        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
       this.isNameEmpty(programmingLanguage);
//        this.isNameAlreadyExist(programmingLanguage);
        pLRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int programmingLanguageId) throws Exception {
        pLRepository.findById(programmingLanguageId).orElseThrow(() -> new Exception("There is no language for this id:" + programmingLanguageId));

        this.pLRepository.deleteById(programmingLanguageId);
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
