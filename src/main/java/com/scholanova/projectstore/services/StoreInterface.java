package com.scholanova.projectstore.services;

import com.scholanova.projectstore.exceptions.ModelNotFoundException;
import com.scholanova.projectstore.exceptions.StoreNameCannotBeEmptyException;
import com.scholanova.projectstore.models.Store;

public interface StoreInterface {

    public Store create(Store store) throws StoreNameCannotBeEmptyException;

    public Store getStoreById(int id) throws ModelNotFoundException;


    public Store delete(Store store) throws ModelNotFoundException ;


    public Store update(Store store) throws StoreNameCannotBeEmptyException;

}
