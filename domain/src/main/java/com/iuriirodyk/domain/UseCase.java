package com.iuriirodyk.domain;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.util.Preconditions;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue> {

private final ThreadExecutor threadExecutor;
private final PostExecutionThread postExecutionThread;
private final CompositeDisposable disposables;

protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
        }

protected abstract Observable<P> buildUseCaseObservable(Q requestValues);

public void execute(DisposableObserver<P> observer, Q requestValues) {
        Preconditions.checkNotNull(observer);
final Observable<P> observable = buildUseCaseObservable(requestValues)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
        }

public void dispose() {
        if (!disposables.isDisposed()) {
        disposables.dispose();
        }
        }

private void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
        }

public interface RequestValues{
}

public interface ResponseValue{
}
}