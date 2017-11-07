package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.ExperiencePeriod;

public interface ExperiencePeriodRepository {
    void saveExperiencePeriod(ExperiencePeriod experiencePeriod);

    void saveExperiencePeriod(List<ExperiencePeriod> experiencePeriodList);
}
