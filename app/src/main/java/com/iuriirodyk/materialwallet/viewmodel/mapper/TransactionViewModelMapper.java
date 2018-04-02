package com.iuriirodyk.materialwallet.viewmodel.mapper;

import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.Issuer;
import com.iuriirodyk.domain.model.Transaction;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;
import com.iuriirodyk.materialwallet.viewmodel.IssuerViewModel;
import com.iuriirodyk.materialwallet.viewmodel.TransactionViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class TransactionViewModelMapper implements Mapper<TransactionViewModel, Transaction> {

    @Inject
    TransactionViewModelMapper(){
    }

    public List<TransactionViewModel> transactionListToViewModel(List<Transaction> entities){
        List<TransactionViewModel> transactionList = new ArrayList<>();
        for(Transaction e : entities){
            transactionList.add(mapToViewModel(e));
        }
        return transactionList;
    }

    @Override
    public Transaction mapFromViewModel(TransactionViewModel e) {
        Issuer issuer = Issuer.create(
                e.card().issuer().issuerName(),
                e.card().issuer().logoImagePath()
        );
        Card card = Card.create(e.card().holder(), e.card().pan(), e.card().expiry(),
                issuer, e.card().cardImagePath(), e.card().balanceTotal(),
                e.card().balanceAvlble(), e.card().balanceBlocked(), e.currency());
        return Transaction.create(e.transId(), Transaction.Type.valueOf(e.type().type()), e.merchant(),
                e.amount(), e.currency(), e.balanceAfter(), e.date(), card);
    }

    @Override
    public TransactionViewModel mapToViewModel(Transaction e) {
        IssuerViewModel issuerEntity = IssuerViewModel.create(
                e.card().issuer().issuerName(),
                e.card().issuer().logoImagePath()
        );
        CardViewModel card = CardViewModel.create(e.card().holder(), e.card().pan(), e.card().expiry(),
                issuerEntity, e.card().cardImagePath(), e.card().balanceTotal(),
                e.card().balanceAvlble(), e.card().balanceBlocked(), e.currency());
        return TransactionViewModel.create(e.transId(), TransactionViewModel.Type.valueOf(e.type().type().toUpperCase()),
                e.merchant(), e.amount(), e.currency(), e.balanceAfter(), e.date(), card);
    }
}
