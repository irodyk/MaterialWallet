package com.iuriirodyk.data.entity.mapper;

import com.iuriirodyk.data.entity.CardEntity;
import com.iuriirodyk.data.entity.TransactionEntity;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class TransactionEntityDataMapper implements Mapper<TransactionEntity, Transaction> {

    @Inject TransactionEntityDataMapper(){
    }

    @Override
    public Transaction mapFromEntity(TransactionEntity e) {
        Card card = Card.create(e.card().holder(), e.card().pan(), e.card().expiry(),
                e.card().issuer(), e.card().cardImagePath(), e.card().balanceTotal(),
                e.card().balanceAvlble(), e.card().balanceBlocked());
        return Transaction.create(e.transId(), Transaction.Type.valueOf(e.type()), e.merchant(), e.amount(), e.currency(),
                                    e.balanceAfter(), e.date(), card);
    }

    @Override
    public TransactionEntity mapToEntity(Transaction e) {
        CardEntity card = CardEntity.create(e.card().holder(), e.card().pan(), e.card().expiry(),
                e.card().issuer(), e.card().cardImagePath(), e.card().balanceTotal(),
                e.card().balanceAvlble(), e.card().balanceBlocked());
        return TransactionEntity.create(e.transId(), e.type().name(), e.merchant(), e.amount(), e.currency(),
                e.balanceAfter(), e.date(), card);
    }

    public List<Transaction> transactionListFromEntity(List<TransactionEntity> entities){
        List<Transaction> transactionList = new ArrayList<>();
        for(TransactionEntity e : entities){
            transactionList.add(mapFromEntity(e));
        }
        return transactionList;
    }
}
