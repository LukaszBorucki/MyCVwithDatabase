package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.ExperienceProject;

public interface ExperienceProjectRepository {
    void saveExperienceProject(ExperienceProject experienceProject);

    void saveExperienceProject(List<ExperienceProject> experienceProjectList);

    List<ExperienceProject> getAllByCompanyId(int id);

    void truncate();
}
