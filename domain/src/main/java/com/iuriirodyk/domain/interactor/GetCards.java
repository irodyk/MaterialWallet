package com.iuriirodyk.domain.interactor;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.interactor.abs.UseCase;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.repository.CardRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public class GetCards extends UseCase<Void, List<Card>> {

    @Inject CardRepository cardRepository;

    @Inject GetCards(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable<List<Card>> buildUseCaseObservable(Void aVoid) {
        return cardRepository.cards();
    }
}
