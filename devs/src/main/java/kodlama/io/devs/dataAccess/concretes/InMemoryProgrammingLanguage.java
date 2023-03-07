package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguage() {
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
        programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                return programmingLanguage;
            }
        }

        return null;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {

        programmingLanguages.add(programmingLanguage);
        System.out.println(programmingLanguage + "programlama dili eklendi");
    }

    @Override
    public ProgrammingLanguage update(int id, ProgrammingLanguage programmingLanguage) {

        for (ProgrammingLanguage pl : programmingLanguages) {
            if (pl.getId() == id) {
                pl.setName(programmingLanguage.getName());
            }
        }
        return programmingLanguage;
    }

    @Override
    public void delete(int id) {

        ProgrammingLanguage validPL = null;
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                validPL = programmingLanguage;
            }
            break;
        }

        if (validPL != null) {
            programmingLanguages.remove(validPL);
        }

    }
}
