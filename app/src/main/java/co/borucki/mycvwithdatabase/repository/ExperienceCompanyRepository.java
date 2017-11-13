package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.ExperienceCompany;

public interface ExperienceCompanyRepository {
    void saveExperienceCompany(ExperienceCompany experienceCompany);

    void saveExperienceCompany(List<ExperienceCompany> experienceCompanyList);

    List<ExperienceCompany> getAllExperienceCompany();

    void truncate();
}
