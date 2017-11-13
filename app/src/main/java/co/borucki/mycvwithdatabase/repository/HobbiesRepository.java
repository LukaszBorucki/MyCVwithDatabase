package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Hobbies;

public interface HobbiesRepository {
    void saveHobbies(List<Hobbies> hobbiesList);

    void saveHobbies(Hobbies hobbies);

    List<Hobbies> getAllHobbiesDataByLanguage();

    void truncate();
}
