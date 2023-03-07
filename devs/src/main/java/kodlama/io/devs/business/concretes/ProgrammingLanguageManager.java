package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository pLRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository pLRepository) {
        this.pLRepository = pLRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return pLRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return pLRepository.getById(id);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        pLRepository.add(programmingLanguage);
    }

    @Override
    public ProgrammingLanguage update(int id, ProgrammingLanguage programmingLanguage) {
        return pLRepository.update(id, programmingLanguage);
    }

    @Override
    public void delete(int id) {
        pLRepository.delete(id);
    }
}
