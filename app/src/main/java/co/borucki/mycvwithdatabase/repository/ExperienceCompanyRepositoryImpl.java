package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.ExperienceCompany;

public class ExperienceCompanyRepositoryImpl implements ExperienceCompanyRepository {
    private static ExperienceCompanyRepositoryImpl mInstance = new ExperienceCompanyRepositoryImpl();
    private final Database mDatabase;

    private ExperienceCompanyRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static ExperienceCompanyRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveExperienceCompany(ExperienceCompany experienceCompany) {
        mDatabase.saveExperienceCompany(experienceCompany);
    }

    @Override
    public void saveExperienceCompany(List<ExperienceCompany> experienceCompanyList) {
        mDatabase.saveExperienceCompany(experienceCompanyList);
    }

    @Override
    public List<ExperienceCompany> getAllExperienceCompany() {
        return mDatabase.getAllExperienceCompany();
    }

    @Override
    public void truncate() {
        mDatabase.truncateExperienceCompany();
    }
}
