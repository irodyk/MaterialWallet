package com.iuriirodyk.domain.interactor;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.interactor.abs.UseCase;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.domain.repository.UserRepository;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public class FetchUser extends UseCase<Void, User> {

    private UserRepository userRepository;

    protected FetchUser(UserRepository userRepository,
                        ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<User> buildUseCaseObservable(Void requestValues) {
        return userRepository.user();
    }
}
