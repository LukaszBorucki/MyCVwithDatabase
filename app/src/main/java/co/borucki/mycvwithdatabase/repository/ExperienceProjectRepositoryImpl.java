package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.ExperienceProject;

public class ExperienceProjectRepositoryImpl implements ExperienceProjectRepository {
    private static ExperienceProjectRepositoryImpl mInstance = new ExperienceProjectRepositoryImpl();
    private final Database mDatabase;

    private ExperienceProjectRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static ExperienceProjectRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveExperienceProject(ExperienceProject experienceProject) {
        mDatabase.saveExperienceProject(experienceProject);
    }

    @Override
    public void saveExperienceProject(List<ExperienceProject> experienceProjectList) {
        mDatabase.saveExperienceProject(experienceProjectList);
    }

    @Override
    public List<ExperienceProject> getAllByCompanyId(int id) {
        return mDatabase.getAllByCompanyId(id);
    }

    @Override
    public void truncate() {
        mDatabase.truncateExperienceProject();
    }
}
