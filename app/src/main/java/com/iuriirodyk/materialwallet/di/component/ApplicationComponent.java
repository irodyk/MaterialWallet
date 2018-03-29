package com.iuriirodyk.materialwallet.di.component;

import android.content.Context;

import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.repository.CardRepository;
import com.iuriirodyk.domain.repository.TransactionRepository;
import com.iuriirodyk.domain.repository.UserRepository;
import com.iuriirodyk.materialwallet.di.module.ApplicationModule;
import com.iuriirodyk.materialwallet.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    
    void inject(BaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    UserRepository userRepository();
    CardRepository cardRepository();
    TransactionRepository transactionRepository();
}
