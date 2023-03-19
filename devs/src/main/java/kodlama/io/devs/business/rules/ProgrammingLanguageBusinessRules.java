package kodlama.io.devs.business.rules;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public void checkIfProgrammingLanguageNameExists(String name) {
        if (this.programmingLanguageRepository.existsByName(name)) {
            throw new BusinessException("This Programming Language name already exists!");
        }
    }
}
