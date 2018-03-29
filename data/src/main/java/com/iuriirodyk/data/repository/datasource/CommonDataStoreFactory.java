package com.iuriirodyk.data.repository.datasource;

import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.Transaction;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 29.03.2018.
 */

@Singleton
public class CommonDataStoreFactory {

    private final LocalAndRemoteDataStore localAndRemoteDataStore;

    @Inject CommonDataStoreFactory() {
        localAndRemoteDataStore = new LocalAndRemoteDataStore();
    }

    public UserDataStore createUserDataStore() {
        //cache should be here. if no cached user found, get it online
        return localAndRemoteDataStore;
    }

    public TransactionDataStore createTransactionDataStore() {
        //go online for transaction history
        return localAndRemoteDataStore;
    }

    public CardDataStore createCardDataStore() {
        //go online if user has enrolled a new card
        return localAndRemoteDataStore;
    }
}
