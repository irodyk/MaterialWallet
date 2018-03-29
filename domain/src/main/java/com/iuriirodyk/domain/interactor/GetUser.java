package com.iuriirodyk.domain.interactor;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.interactor.abs.UseCase;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public class GetUser extends UseCase<Void, User> {

    @Inject UserRepository userRepository;

    @Inject GetUser(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable<User> buildUseCaseObservable(Void aVoid) {
        return userRepository.user();
    }
}
