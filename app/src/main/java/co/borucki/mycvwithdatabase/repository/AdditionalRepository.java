package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Additional;

public interface AdditionalRepository {
    void saveAdditional(List<Additional> additionalList);

    void saveAdditional(Additional additional);

    List<Additional> getAllAdditional();

    void truncate();
}
