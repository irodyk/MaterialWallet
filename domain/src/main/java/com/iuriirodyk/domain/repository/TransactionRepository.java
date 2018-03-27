package com.iuriirodyk.domain.repository;

import com.iuriirodyk.domain.model.Transaction;

import java.util.List;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

/**
 * Contract to TransactionDataRepository in data module.
 */
public interface TransactionRepository {

    /**
     * Fetches transactions made by selected card.
     * @param cardPan - card number of selected card.
     * @return - actual list of Transactions.
     */
    Observable<List<Transaction>> transactions(String cardPan);
}
