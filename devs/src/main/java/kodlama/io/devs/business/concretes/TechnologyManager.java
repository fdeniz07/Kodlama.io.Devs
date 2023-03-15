package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.*;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.core.utilities.enums.LanguageMessageEnum;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyRepository tRepository;
    private final ProgrammingLanguageRepository pLRepository;

    public TechnologyManager(TechnologyRepository tRepository, ProgrammingLanguageRepository pLRepository) {
        this.tRepository = tRepository;
        this.pLRepository = pLRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {

        List<Technology> technologies = tRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<>();

        for (Technology technology : technologies) {

            GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());

            technologiesResponses.add(responseItem);
        }

        return technologiesResponses;
    }

    @Override
    public GetAllTechnologiesResponse getById(int id) {

        GetAllTechnologiesResponse technologiesResponse = new GetAllTechnologiesResponse();
        Technology Technology = tRepository.findById(id).orElseThrow();
        technologiesResponse.setName(Technology.getName());

        return technologiesResponse;
    }


    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {

        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getTechnology());
        //technology.set(technology.getProgrammingLanguage().getId());
        this.isNameEmpty(technology);
        this.isNameAlreadyExist(technology);
        tRepository.save(technology);
    }

    @Override
    public void update(int technologyId, UpdateTechnologyRequest updateTechnologyRequest) throws Exception {

        Technology Technology = tRepository.findById(technologyId).orElseThrow(() -> new Exception("There is no technology for this id:" + technologyId));
        Technology.setName(updateTechnologyRequest.getTechnology());
        this.isNameEmpty(Technology);
        //this.isNameAlreadyExist(Technology);
        tRepository.save(Technology);
    }

    @Override
    public void delete(int technologyId, DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {

        Technology Technology = tRepository.findById(technologyId).orElseThrow(() -> new Exception("There is no technology for this id:" + technologyId));

        this.tRepository.deleteById(technologyId);
    }

    @Override
    public void isNameEmpty(Technology Technology) throws Exception {
        if (Technology.getName().trim().isEmpty() || Technology.getName().isBlank()) {

            throw new Exception(LanguageMessageEnum.NOTNULL.getMessage());
        }
    }

    @Override
    public void isNameAlreadyExist(Technology Technology) throws Exception {
        List<Technology> languageList = tRepository.findAll();

        for (Technology pl : languageList) {
            if (pl.getName().equalsIgnoreCase((Technology.getName()))) {

                throw new Exception(LanguageMessageEnum.ALREADYEXIST.getMessage());
            }
        }
    }
}
