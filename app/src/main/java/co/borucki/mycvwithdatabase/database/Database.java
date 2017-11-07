package co.borucki.mycvwithdatabase.database;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Education;

public interface Database {

    void saveEducation(List<Education> educationList);

    void saveEducation(Education education);



}
