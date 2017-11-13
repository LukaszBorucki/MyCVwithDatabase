package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.ForeignLanguage;

public class ForeignLanguageRepositoryImpl implements ForeignLanguageRepository {
    private static ForeignLanguageRepositoryImpl mInstance = new ForeignLanguageRepositoryImpl();
    private final Database mDatabase;

    private ForeignLanguageRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static ForeignLanguageRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveForeignLanguage(List<ForeignLanguage> foreignLanguageList) {
        for (ForeignLanguage foreignLanguage : foreignLanguageList) {
            mDatabase.saveForeignLanguage(foreignLanguageList);
        }
    }

    @Override
    public void saveForeignLanguage(ForeignLanguage foreignLanguage) {
        mDatabase.saveForeignLanguage(foreignLanguage);
    }

    @Override
    public List<ForeignLanguage> getAllForeignLanguage() {
        return mDatabase.getAllForeignLanguage();
    }

    @Override
    public void truncate() {
        mDatabase.truncateExperienceForeignLanguage();
    }
}
