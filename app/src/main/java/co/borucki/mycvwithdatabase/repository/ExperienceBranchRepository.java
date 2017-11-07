package co.borucki.mycvwithdatabase.repository;

import java.util.List;

import co.borucki.mycvwithdatabase.model.ExperienceBranch;

public interface ExperienceBranchRepository {
    void saveExperienceBranch(ExperienceBranch experienceBranch);

    void saveExperienceBranch(List<ExperienceBranch> experienceBranchList);

}
