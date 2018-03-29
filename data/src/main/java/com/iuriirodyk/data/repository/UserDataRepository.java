package com.iuriirodyk.data.repository;

import com.iuriirodyk.data.entity.mapper.UserEntityDataMapper;
import com.iuriirodyk.data.repository.datasource.CommonDataStoreFactory;
import com.iuriirodyk.data.repository.datasource.UserDataStore;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class UserDataRepository implements UserRepository {

    @Inject CommonDataStoreFactory commonDataStoreFactory;
    @Inject UserEntityDataMapper mapper;

    @Inject UserDataRepository(){
    }

    @Override
    public Observable<User> user() {
        UserDataStore userDataStore = commonDataStoreFactory.createUserDataStore();
        return userDataStore.userEntity().map(mapper::mapFromEntity);
    }
}
