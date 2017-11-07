package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Education;

public interface EducationRepository {

    void saveEducation(List<Education> educationList);

    void saveEducation(Education education);
}
