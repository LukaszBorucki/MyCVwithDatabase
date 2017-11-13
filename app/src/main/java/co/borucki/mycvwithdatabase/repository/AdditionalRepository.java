package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Additional;
import co.borucki.mycvwithdatabase.model.Hobbies;

public interface AdditionalRepository {
    void saveAdditional(List<Additional> additionalList);

    void saveAdditional(Additional additional);

    List<Additional> getAllAdditional();

    void truncate();
}
