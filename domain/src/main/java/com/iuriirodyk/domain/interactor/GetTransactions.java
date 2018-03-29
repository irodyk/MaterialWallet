package com.iuriirodyk.domain.interactor;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.interactor.abs.UseCase;
import com.iuriirodyk.domain.model.Transaction;
import com.iuriirodyk.domain.repository.TransactionRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public class GetTransactions extends UseCase<String, List<Transaction>> {

    @Inject TransactionRepository transactionRepository;

    @Inject GetTransactions(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable<List<Transaction>> buildUseCaseObservable(String cardPan) {
        return transactionRepository.transactions(cardPan);
    }
}
