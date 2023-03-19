package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.dtos.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.dtos.requests.UpdateTechnologyRequest;

import kodlama.io.devs.business.dtos.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.dtos.responses.GetByIdTechnologyResponse;
import kodlama.io.devs.business.rules.TechnologyBusinessRules;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

    private final TechnologyRepository tRepository;
    private ModelMapperService modelMapperService;
    private TechnologyBusinessRules technologyBusinessRules;

    @Override
    public List<GetAllTechnologiesResponse> getAll() {

        List<Technology> technologies = tRepository.findAll();
//        List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<>();
//
//        for (Technology technology : technologies) {
//
//            GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
//            responseItem.setId(technology.getId());
//            responseItem.setName(technology.getName());
//
//            technologiesResponses.add(responseItem);
//        }
//
//        return technologiesResponses;

        return technologies
                .stream()
                .map(technology -> this.modelMapperService.forResponse()
                        .map(technology, GetAllTechnologiesResponse.class)).toList();
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {

        Technology technology = this.tRepository.findById(id).orElseThrow();
//        GetAllTechnologiesResponse technologiesResponse = new GetAllTechnologiesResponse();
//        technologiesResponse.setName(Technology.getName());
//
//        return technologiesResponse;

        return this.modelMapperService.forResponse().map(technology, GetByIdTechnologyResponse.class);
    }


    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {

//        Technology technology = new Technology();
//        technology.setName(createTechnologyRequest.getTechnology());
//        //technology.set(technology.getProgrammingLanguage().getId());
////        this.isNameEmpty(technology);
////        this.isNameAlreadyExist(technology);
//        tRepository.save(technology);
        this.technologyBusinessRules.checkIfTechnologyNameExists(createTechnologyRequest.getName());

        Technology technology = this.modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
        this.tRepository.save(technology);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {

//        Technology Technology = tRepository.findById(technologyId).orElseThrow(() -> new Exception("There is no technology for this id:" + technologyId));
//        Technology.setName(updateTechnologyRequest.getTechnology());
////        this.isNameEmpty(Technology);
////        this.isNameAlreadyExist(Technology);
//        tRepository.save(Technology);
        this.technologyBusinessRules.checkIfTechnologyNameExists(updateTechnologyRequest.getName());

        Technology technology = this.modelMapperService.forRequest().map(updateTechnologyRequest, Technology.class);
        this.tRepository.save(technology);
    }

    @Override
    public void delete(int id) {

//        Technology Technology = tRepository.findById(technologyId).orElseThrow(() -> new Exception("There is no technology for this id:" + technologyId));
//
//        this.tRepository.deleteById(technologyId);

        this.tRepository.deleteById(id);
    }


//    @Override
//    public void isNameAlreadyExist(Technology Technology) throws Exception {
//        List<Technology> languageList = tRepository.findAll();
//
//        for (Technology technology : languageList) {
//            if (technology.getName().equalsIgnoreCase((Technology.getName()))) {
//
//                throw new Exception(LanguageMessageEnum.ALREADYEXIST.getMessage());
//            }
//        }
//    }
}
