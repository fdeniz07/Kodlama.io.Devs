package kodlama.io.devs.business.rules;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TechnologyBusinessRules {

    private TechnologyRepository technologyRepository;

    public void checkIfTechnologyNameExists(String name) {

        if (this.technologyRepository.existsByName(name)) {
            throw new BusinessException("This Technology already exists!");
        }
    }

}

