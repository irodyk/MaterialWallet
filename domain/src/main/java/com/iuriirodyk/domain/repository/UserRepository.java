package com.iuriirodyk.domain.repository;

import com.iuriirodyk.domain.model.User;

import io.reactivex.Observable;


/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

/**
 * Contract to UserDataRepository in data module.
 */
public interface UserRepository {

    /**
     * Fetches registered user details.
     * @return - actual User.
     */
    Observable<User> user();
}
