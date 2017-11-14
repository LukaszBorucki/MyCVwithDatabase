package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.Additional;

public class AdditionalRepositoryImpl implements AdditionalRepository {
    private static AdditionalRepositoryImpl mInstance = new AdditionalRepositoryImpl();
    private final Database mDatabase;

    private AdditionalRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static AdditionalRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveAdditional(List<Additional> additionalList) {
        mDatabase.saveAdditional(additionalList);
    }

    @Override
    public void saveAdditional(Additional additional) {
        mDatabase.saveAdditional(additional);
    }

    @Override
    public List<Additional> getAllAdditional() {
        return mDatabase.getAllAdditional();
    }

    @Override
    public void truncate() {
        mDatabase.truncateAdditional();
    }
}
