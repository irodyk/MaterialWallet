package com.iuriirodyk.data.repository.datasource;

import com.iuriirodyk.data.entity.CardEntity;
import com.iuriirodyk.data.entity.TransactionEntity;
import com.iuriirodyk.data.entity.UserEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 29.03.2018.
 */

public class LocalAndRemoteDataStore implements UserDataStore, CardDataStore, TransactionDataStore {



    @Override
    public Observable<UserEntity> userEntity() {
        return null;
    }

    @Override
    public Observable<List<CardEntity>> cardEntities() {
        return null;
    }

    @Override
    public Observable<List<TransactionEntity>> transactionEntities() {
        return null;
    }
}
