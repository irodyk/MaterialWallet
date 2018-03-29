package com.iuriirodyk.data.entity.mapper;

import com.iuriirodyk.data.entity.CardEntity;
import com.iuriirodyk.data.entity.IssuerEntity;
import com.iuriirodyk.data.entity.TransactionEntity;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.Issuer;
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
        Issuer issuer = Issuer.create(
                e.card().issuer().issuerName(),
                e.card().issuer().logoImagePath()
        );
        Card card = Card.create(e.card().holder(), e.card().pan(), e.card().expiry(),
                issuer, e.card().cardImagePath(), e.card().balanceTotal(),
                e.card().balanceAvlble(), e.card().balanceBlocked(), e.currency());
        return Transaction.create(e.transId(), Transaction.Type.valueOf(e.type()), e.merchant(), e.amount(), e.currency(),
                e.balanceAfter(), e.date(), card);
    }

    @Override
    public TransactionEntity mapToEntity(Transaction e) {
        IssuerEntity issuerEntity = IssuerEntity.create(
                e.card().issuer().issuerName(),
                e.card().issuer().logoImagePath()
        );
        CardEntity card = CardEntity.create(e.card().holder(), e.card().pan(), e.card().expiry(),
                issuerEntity, e.card().cardImagePath(), e.card().balanceTotal(),
                e.card().balanceAvlble(), e.card().balanceBlocked(), e.currency());
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
