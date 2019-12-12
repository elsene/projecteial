package com.scholanova.projectstore.services;

import com.scholanova.projectstore.exceptions.ModelNotFoundException;
import com.scholanova.projectstore.exceptions.StoreNameCannotBeEmptyException;
import com.scholanova.projectstore.models.Store;
import com.scholanova.projectstore.repositories.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements StoreInterface{

    private StoreRepository storeRepository;
    private StoreInterface storeInterface;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    public StoreService(StoreInterface storeInterface){
        this.storeInterface = storeInterface;
    }

    public Store create(Store store) throws StoreNameCannotBeEmptyException {

        if (isNameMissing(store)) {
            throw new StoreNameCannotBeEmptyException();
        }

        return storeRepository.create(store);
    }

    public Store getStoreById(int id) throws ModelNotFoundException  {

        return storeRepository.getById(id);
    }

    private boolean isNameMissing(Store store) {
        return store.getName() == null ||
                store.getName().trim().length() == 0;
    }

    public Store delete(Store store) throws ModelNotFoundException  {

        return storeRepository.delete(store);
    }

    public Store update(Store store) throws StoreNameCannotBeEmptyException {
        if (isNameMissing(store)) {
            throw new StoreNameCannotBeEmptyException();
        }

        return storeRepository.update(store);
    }
}
