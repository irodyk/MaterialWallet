package com.iuriirodyk.data.repository.datasource;

import com.iuriirodyk.data.entity.UserEntity;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 29.03.2018.
 */

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {

    /**
     * Get an {@link Observable} which will emit a {@link UserEntity}
     */
    Observable<UserEntity> userEntity();
}
