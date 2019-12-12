package com.scholanova.projectstore.controllers;

import com.scholanova.projectstore.exceptions.ModelNotFoundException;
import com.scholanova.projectstore.exceptions.StoreNameCannotBeEmptyException;
import com.scholanova.projectstore.models.Store;
import com.scholanova.projectstore.services.StoreService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping(path = "/stores/{id}")
    public Store getStation(@PathVariable int id) {
        try {
            return storeService.getStoreById(id);
        } catch (ModelNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;

    }

    @SuppressWarnings("finally")
    @DeleteMapping(path = "/stores")
    public String deleteStation(@RequestBody Store store) {
        try {
            storeService.delete(store);
            return "Magasin supprimé";
        } catch (ModelNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();

            e.getMessage();
        }
        return "Probleme";
    }

    @PostMapping(path = "/stores")
    public Store createStore(@RequestBody Store store) throws StoreNameCannotBeEmptyException {
        return storeService.create(store);
    }

    @PutMapping(path = "/stores")
    public Store updateStore(@RequestBody Store store) throws StoreNameCannotBeEmptyException {
        return storeService.update(store);
    }

}
