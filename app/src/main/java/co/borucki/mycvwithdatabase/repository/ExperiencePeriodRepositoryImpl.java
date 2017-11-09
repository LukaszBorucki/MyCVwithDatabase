package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.ExperiencePeriod;

public class ExperiencePeriodRepositoryImpl implements ExperiencePeriodRepository {

    private static ExperiencePeriodRepositoryImpl mInstance = new ExperiencePeriodRepositoryImpl();
    private final Database mDatabase;

    private ExperiencePeriodRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static ExperiencePeriodRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveExperiencePeriod(ExperiencePeriod experiencePeriod) {
        mDatabase.saveExperiencePeriod(experiencePeriod);
    }

    @Override
    public void saveExperiencePeriod(List<ExperiencePeriod> experiencePeriodList) {
        mDatabase.saveExperiencePeriod(experiencePeriodList);
    }

    @Override
    public List<ExperiencePeriod> getAllByCompanyIdByLanguage(int id, String appLanguage) {
        return mDatabase.getAllByCompanyIdByLanguage(id, appLanguage);
    }

    @Override
    public void truncate() {
        mDatabase.truncateExperiencePeriod();
    }
}
