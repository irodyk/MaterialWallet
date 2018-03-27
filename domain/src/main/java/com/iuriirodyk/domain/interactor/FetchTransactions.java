package com.iuriirodyk.domain.interactor;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.interactor.abs.UseCase;
import com.iuriirodyk.domain.model.Transaction;
import com.iuriirodyk.domain.repository.TransactionRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public class FetchTransactions extends UseCase<String, List<Transaction>> {

    private TransactionRepository transactionRepository;

    protected FetchTransactions(TransactionRepository transactionRepository,
                                ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.transactionRepository = transactionRepository;
    }

    @Override
    protected Observable<List<Transaction>> buildUseCaseObservable(String cardPan) {
        return transactionRepository.transactions(cardPan);
    }
}
