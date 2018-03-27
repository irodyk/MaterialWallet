package com.iuriirodyk.domain.interactor.abs;

import io.reactivex.observers.DisposableObserver;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {

    @Override public void onComplete() {
        //no default implementation
    }

    @Override public void onError(Throwable e) {
        //no default implementation
    }

    @Override public void onNext(T t) {
        //no default implementation
    }
}
