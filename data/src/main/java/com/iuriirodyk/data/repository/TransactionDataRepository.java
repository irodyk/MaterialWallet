package com.iuriirodyk.data.repository;

import com.iuriirodyk.data.entity.mapper.TransactionEntityDataMapper;
import com.iuriirodyk.data.repository.datasource.CommonDataStoreFactory;
import com.iuriirodyk.data.repository.datasource.TransactionDataStore;
import com.iuriirodyk.domain.model.Transaction;
import com.iuriirodyk.domain.repository.TransactionRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class TransactionDataRepository implements TransactionRepository {

    @Inject CommonDataStoreFactory commonDataStoreFactory;
    @Inject TransactionEntityDataMapper mapper;

    @Inject TransactionDataRepository(){
    }

    @Override
    public Observable<List<Transaction>> transactions(String cardPan) {
        TransactionDataStore transactionDataStore = commonDataStoreFactory.createTransactionDataStore();
        return transactionDataStore.transactionEntities().map(mapper::transactionListFromEntity);
    }
}
