package com.scholanova.projectstore.services;

import com.scholanova.projectstore.exceptions.ModelNotFoundException;
import com.scholanova.projectstore.exceptions.StoreNameCannotBeEmptyException;
import com.scholanova.projectstore.models.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoreGateway implements StoreInterface {


    List<Store> storeList = new ArrayList<>();

    StoreGateway()
    {
        storeList.add(0,new Store(2,"test"));
    }




    @Override
    public Store create(Store store) throws StoreNameCannotBeEmptyException {
        this.storeList.add(store);
        return this.storeList.get(0);
    }

    @Override
    public Store getStoreById(int id) throws ModelNotFoundException {
        Optional<Store> store=  this.storeList.stream()
                .filter(storer -> storer.getId().equals(id))
                .findFirst();

       return  store.get();

    }

    @Override
    public Store delete(Store store) throws ModelNotFoundException {
        return null;
    }

    @Override
    public Store update(Store store) throws StoreNameCannotBeEmptyException {
        return null;
    }
}
