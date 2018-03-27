package com.iuriirodyk.domain.interactor;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.interactor.abs.UseCase;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.repository.CardRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public class FetchCards extends UseCase<Void, List<Card>> {

    private CardRepository cardRepository;

    protected FetchCards(CardRepository cardRepository,
                         ThreadExecutor threadExecutor,
                         PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.cardRepository = cardRepository;
    }

    @Override
    protected Observable<List<Card>> buildUseCaseObservable(Void requestValues) {
        return cardRepository.cards();
    }
}
