package co.borucki.mycvwithdatabase.repository;

import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.ExperienceBranch;

public class ExperienceBranchRepositoryImpl implements ExperienceBranchRepository {
    private static ExperienceBranchRepositoryImpl mInstance = new ExperienceBranchRepositoryImpl();
    private final Database mDatabase;

    private ExperienceBranchRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static ExperienceBranchRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveExperienceBranch(ExperienceBranch experienceBranch) {
        mDatabase.saveExperienceBranch(experienceBranch);
    }

    @Override
    public void saveExperienceBranch(List<ExperienceBranch> experienceBranchList) {
        mDatabase.saveExperienceBranch(experienceBranchList);
    }

    @Override
    public ExperienceBranch getBranchByBranchId(int branchId) {
        return mDatabase.getBranchByBranchId(branchId);
    }

    @Override
    public void truncate() {
        mDatabase.truncateExperienceBranch();
    }
}
