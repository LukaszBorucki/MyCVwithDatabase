package co.borucki.mycvwithdatabase.repository;

import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.Education;

public class EducationRepositoryImpl implements EducationRepository {
    private static EducationRepositoryImpl mInstance = new EducationRepositoryImpl();
    private final Database mDatabase;

    private EducationRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }
    public static EducationRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveEducation(List<Education> educationList) {
        mDatabase.saveEducation(educationList);
    }

    @Override
    public void saveEducation(Education education) {
        mDatabase.saveEducation(education);
    }
}
