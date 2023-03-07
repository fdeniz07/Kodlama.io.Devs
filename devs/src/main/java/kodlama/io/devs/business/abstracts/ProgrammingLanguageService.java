package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id);

    void add(ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage update(int id,ProgrammingLanguage programmingLanguage);

    void delete(int id);
}
