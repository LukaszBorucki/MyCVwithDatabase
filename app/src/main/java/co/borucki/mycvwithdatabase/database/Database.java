package co.borucki.mycvwithdatabase.database;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Education;
import co.borucki.mycvwithdatabase.model.ExperienceBranch;
import co.borucki.mycvwithdatabase.model.ExperienceCompany;
import co.borucki.mycvwithdatabase.model.ExperiencePeriod;
import co.borucki.mycvwithdatabase.model.ExperienceProject;
import co.borucki.mycvwithdatabase.model.ForeignLanguage;
import co.borucki.mycvwithdatabase.model.Hobbies;
import co.borucki.mycvwithdatabase.model.Skill;

public interface Database {

    void saveEducation(List<Education> educationList);

    void saveEducation(Education education);

    void saveExperienceBranch(List<ExperienceBranch> experienceBranchList);

    void saveExperienceBranch(ExperienceBranch experienceBranch);

    void saveExperienceCompany(ExperienceCompany experienceCompany);

    void saveExperienceCompany(List<ExperienceCompany> experienceCompanyList);

    void saveExperiencePeriod(ExperiencePeriod experiencePeriod);

    void saveExperiencePeriod(List<ExperiencePeriod> experiencePeriodList);

    void saveExperienceProject(ExperienceProject experienceProject);

    void saveExperienceProject(List<ExperienceProject> experienceProjectList);

    void saveForeignLanguage(List<ForeignLanguage> foreignLanguageList);

    void saveForeignLanguage(ForeignLanguage foreignLanguage);

    void saveHobbies(List<Hobbies> hobbiesList);

    void saveHobbies(Hobbies hobbies);

    void saveSkill(List<Skill> skillList);

    void saveSkill(Skill skill);


}
