package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.ForeignLanguage;

public interface ForeignLanguageRepository {
    void saveForeignLanguage(List<ForeignLanguage> foreignLanguageList);

    void saveForeignLanguage(ForeignLanguage foreignLanguage);

    List<ForeignLanguage> getAllForeignLanguage();

    void truncate();
}
