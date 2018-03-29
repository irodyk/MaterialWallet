package com.iuriirodyk.data.repository.datasource;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 29.03.2018.
 */

import com.iuriirodyk.data.entity.TransactionEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface TransactionDataStore {

    /**
     * Get an {@link Observable} which will emit a list of {@link TransactionEntity}
     */
    Observable<List<TransactionEntity>> transactionEntities();
}
