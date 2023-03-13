package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id);

    void add(ProgrammingLanguage programmingLanguage) throws Exception;

    ProgrammingLanguage update(int id,ProgrammingLanguage programmingLanguage) throws Exception;

    void delete(int id);

    void isNameEmpty(ProgrammingLanguage programmingLanguage) throws Exception;

    void isNameAlreadyExist(ProgrammingLanguage programmingLanguage) throws Exception;
}
