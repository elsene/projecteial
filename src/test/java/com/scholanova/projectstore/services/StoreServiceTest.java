package com.scholanova.projectstore.services;

import com.scholanova.projectstore.exceptions.StoreNameCannotBeEmptyException;
import com.scholanova.projectstore.models.Store;
import com.scholanova.projectstore.repositories.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {

    private StoreService storeService;

    @Mock
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
        storeService = new StoreService(storeRepository);
    }

    @Test
    void givenNoStoreName_whenCreated_failsWithNoEmptyStoreNameError() {
        // GIVEN
        Integer id = null;
        String name = null;

        Store emptyNameStore = new Store(id, name);

        // WHEN
        assertThrows(StoreNameCannotBeEmptyException.class, () -> {
            storeService.create(emptyNameStore);
        });

        // THEN
        verify(storeRepository, never()).create(emptyNameStore);
    }

    @Test
    void givenCorrectStore_whenCreated_savesStoreInRepository() throws Exception {
        // GIVEN
        Integer id = 1234;
        String name = "BHV";

        Store correctStore = new Store(null, name);
        Store savedStore = new Store(id, name);
        when(storeRepository.create(correctStore)).thenReturn(savedStore);

        // WHEN
        Store returnedStore = storeService.create(correctStore);

        // THEN
        verify(storeRepository, atLeastOnce()).create(correctStore);
        assertThat(returnedStore).isEqualTo(savedStore);
        System.out.println(returnedStore);
    }

    @Test
    void shouldFindAGivenStore() throws Exception {
        // GIVEN
       /* Integer id = 2;
        StoreGateway storeGateway = new StoreGateway();

        //when
        Store storeResult = storeGateway.getStoreById(id);

        // THEN

        //assertThat(storeResult).isNotNull();
        assertThat(storeResult).extracting(Store::getId,Store::getName)
        .contains(2,"test");*/



        Integer ids = 2;
        String name = "test";

        Store correctStore = new Store(null, name);
        Store savedStore = new Store(ids, name);
        when(storeRepository.getById(ids)).thenReturn(savedStore);

        // WHEN
        Store returnedStore = storeService.getStoreById(ids);

        // THEN
        verify(storeRepository, atLeastOnce()).getById(ids);
        assertThat(returnedStore).isEqualTo(savedStore);
        System.out.println(returnedStore);

    }

    @Test
    void shoulDeleteAGivenStore() throws Exception {

        Integer ids = 2;
        String name = "test";

        Store correctStore = new Store(2, name);
        Store savedStore = new Store(null, null);
        when(storeRepository.delete(correctStore)).thenReturn(savedStore);

        // WHEN
        Store returnedStore = storeService.delete(correctStore);

        // THEN
        verify(storeRepository, atLeastOnce()).delete(correctStore);
        assertThat(returnedStore).isEqualTo(savedStore);
        System.out.println(returnedStore);

    }


    @Test
    void shoulUpdateAGivenStore() throws Exception {

        Integer ids = 2;
        String name = "testupdate";

        Store correctStore = new Store(2, name);
        Store savedStore = new Store(2, name);
        when(storeRepository.update(correctStore)).thenReturn(savedStore);

        // WHEN
        Store returnedStore = storeService.update(correctStore);

        // THEN
        verify(storeRepository, atLeastOnce()).update(correctStore);
        assertThat(returnedStore).isEqualTo(savedStore);
        System.out.println(returnedStore);

    }





}