package com.iuriirodyk.materialwallet.presenter;

import com.iuriirodyk.domain.interactor.GetTransactions;
import com.iuriirodyk.domain.interactor.abs.UseCaseObserver;
import com.iuriirodyk.domain.model.Transaction;
import com.iuriirodyk.materialwallet.view.TransactionsView;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;
import com.iuriirodyk.materialwallet.viewmodel.mapper.TransactionViewModelMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 01.04.2018.
 */

public class TransactionsPresenter implements Presenter<TransactionsView> {

    @Inject GetTransactions getTransactions;

    @Inject TransactionViewModelMapper transactionMapper;

    private TransactionsView view;

    @Inject
    TransactionsPresenter(){
    }

    public void getTransactions(CardViewModel card){
        getTransactions.execute(new GetTransactionsObserver(), card.pan());
    }

    @Override
    public void setView(TransactionsView view) {
        this.view = view;
    }

    @Override
    public void dispose() {
        getTransactions.dispose();
        view = null;
    }

    private final class GetTransactionsObserver extends UseCaseObserver<List<Transaction>> {
        @Override
        public void onNext(List<Transaction> transactions) {
            view.renderTransactions(transactionMapper.transactionListToViewModel(transactions));
        }

        @Override
        public void onError(Throwable e) {
            view.onError(e.getMessage());
        }
    }
}
