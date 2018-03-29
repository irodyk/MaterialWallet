package com.iuriirodyk.data.repository.datasource;

import com.iuriirodyk.data.entity.CardEntity;
import com.iuriirodyk.data.entity.IssuerEntity;
import com.iuriirodyk.data.entity.TransactionEntity;
import com.iuriirodyk.data.entity.UserEntity;
import com.iuriirodyk.domain.model.Card;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 29.03.2018.
 */

public class LocalAndRemoteDataStore implements UserDataStore, CardDataStore, TransactionDataStore {

    @Override
    public Observable<UserEntity> userEntity() {
        return Observable.create(emitter -> {
            UserEntity userEntity = Mock.userEntity();

            emitter.onNext(userEntity);
            emitter.onComplete();
        });
    }

    @Override
    public Observable<List<CardEntity>> cardEntities() {
        return Observable.create(emitter -> {
            List<CardEntity> cardEntities = new ArrayList<>();

            cardEntities.add(Mock.cardEntity1());
            cardEntities.add(Mock.cardEntity2());
            cardEntities.add(Mock.cardEntity3());

            emitter.onNext(cardEntities);
            emitter.onComplete();
        });
    }

    @Override
    public Observable<List<TransactionEntity>> transactionEntities(String cardPan) {
        return Observable.create(emitter -> {

            List<TransactionEntity> transactionEntities = new ArrayList<>();

            //fetch transactions for given card number
            for(int i = 0; i < 10; i++){
                transactionEntities.add(Mock.transactionEntities()[i]);
            }

            emitter.onNext(transactionEntities);
            emitter.onComplete();
        });
    }
}
