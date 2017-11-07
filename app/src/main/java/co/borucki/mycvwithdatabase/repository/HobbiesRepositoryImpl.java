package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.Hobbies;

public class HobbiesRepositoryImpl implements HobbiesRepository {
    private static HobbiesRepositoryImpl mInstance = new HobbiesRepositoryImpl();
    private final Database mDatabase;

    private HobbiesRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static HobbiesRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveHobbies(List<Hobbies> hobbiesList) {
        for (Hobbies hobbies : hobbiesList) {
            mDatabase.saveHobbies(hobbiesList);
        }
    }

    @Override
    public void saveHobbies(Hobbies hobbies) {
        mDatabase.saveHobbies(hobbies);
    }
}
