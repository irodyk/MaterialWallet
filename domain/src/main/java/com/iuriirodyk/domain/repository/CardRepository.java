package com.iuriirodyk.domain.repository;

import com.iuriirodyk.domain.model.Card;

import java.util.List;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

/**
 * Contract to CardDataRepository in data module.
 */
public interface CardRepository {

    /**
     * Fetches cards registered user possesses.
     * @return - actual list of Cards.
     */
    Observable<List<Card>> cards();
}
