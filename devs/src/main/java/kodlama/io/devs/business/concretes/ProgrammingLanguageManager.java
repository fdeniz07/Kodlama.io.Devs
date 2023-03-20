package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.dtos.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.dtos.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.dtos.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.dtos.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.business.rules.ProgrammingLanguageBusinessRules;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository pLRepository;
    private ModelMapperService modelMapperService;
    private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {

        List<ProgrammingLanguage> programmingLanguages = pLRepository.findAll();
//        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<>();
//
//        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
//
//            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
//            responseItem.setId(programmingLanguage.getId());
//            responseItem.setName(programmingLanguage.getName());
//
//            programmingLanguagesResponses.add(responseItem);
//        }
//
//        return programmingLanguagesResponses;

        return programmingLanguages
                .stream()
                .map(programmingLanguage -> this.modelMapperService.forResponse()
                        .map(programmingLanguage, GetAllProgrammingLanguagesResponse.class)).toList();
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {

        ProgrammingLanguage programmingLanguage = pLRepository.findById(id).orElseThrow();
//        GetAllProgrammingLanguagesResponse programmingLanguagesResponse = new GetAllProgrammingLanguagesResponse();
//        programmingLanguagesResponse.setName(programmingLanguage.getName());
//
//        return programmingLanguagesResponse;

        return this.modelMapperService.forResponse().map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
    }


    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {

//        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
//        programmingLanguage.setName(createProgrammingLanguageRequest.getName());
////        this.isNameEmpty(programmingLanguage);
////        this.isNameAlreadyExist(programmingLanguage);
//        pLRepository.save(programmingLanguage);
        this.programmingLanguageBusinessRules.checkIfProgrammingLanguageNameExists(createProgrammingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
        programmingLanguage.setId(0);
        this.pLRepository.save(programmingLanguage);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {

//        ProgrammingLanguage programmingLanguage = pLRepository.findById(programmingLanguageId).orElseThrow(() -> new Exception("There is no language for this id:" + programmingLanguageId));
//        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
////       this.isNameEmpty(programmingLanguage);
////       this.isNameAlreadyExist(programmingLanguage);
//        pLRepository.save(programmingLanguage);

        this.programmingLanguageBusinessRules.checkIfProgrammingLanguageNameExists(updateProgrammingLanguageRequest.getName());

        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
        programmingLanguage.setId(0);
        this.pLRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
//        pLRepository.findById(programmingLanguageId).orElseThrow(() -> new Exception("There is no language for this id:" + programmingLanguageId));
//
//        this.pLRepository.deleteById(programmingLanguageId);
        this.pLRepository.deleteById(id);
    }

//    @Override
//    public void isNameEmpty(ProgrammingLanguage programmingLanguage) throws Exception {
//        if (programmingLanguage.getName().trim().isEmpty() || programmingLanguage.getName().isBlank()) {
//
//            throw new Exception(LanguageMessageEnum.NOTNULL.getMessage());
//        }
//    }

//    @Override
//    public void isNameAlreadyExist(ProgrammingLanguage programmingLanguage) throws Exception {
//        List<ProgrammingLanguage> languageList = pLRepository.findAll();
//
//        for (ProgrammingLanguage pl : languageList) {
//            if (pl.getName().equalsIgnoreCase((programmingLanguage.getName()))) {
//
//                throw new Exception(LanguageMessageEnum.ALREADYEXIST.getMessage());
//            }
//        }
//    }
}
