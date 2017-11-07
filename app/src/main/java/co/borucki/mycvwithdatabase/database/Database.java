package co.borucki.mycvwithdatabase.database;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Education;
import co.borucki.mycvwithdatabase.model.ExperienceBranch;

public interface Database {

    void saveEducation(List<Education> educationList);

    void saveEducation(Education education);

    void saveExperienceBranch(List<ExperienceBranch> experienceBranchList);

    void saveExperienceBranch(ExperienceBranch experienceBranch);


}
