package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.ExperiencePeriod;
import co.borucki.mycvwithdatabase.model.ExperienceProject;

public interface ExperiencePeriodRepository {
    void saveExperiencePeriod(ExperiencePeriod experiencePeriod);

    void saveExperiencePeriod(List<ExperiencePeriod> experiencePeriodList);

    List<ExperiencePeriod> getAllByCompanyIdByLanguage(int id, String appLanguage);

    void truncate();
}
