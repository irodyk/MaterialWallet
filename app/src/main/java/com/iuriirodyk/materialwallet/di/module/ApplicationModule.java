package com.iuriirodyk.materialwallet.di.module;

import android.content.Context;

import com.iuriirodyk.data.executor.JobExecutor;
import com.iuriirodyk.data.repository.CardDataRepository;
import com.iuriirodyk.data.repository.TransactionDataRepository;
import com.iuriirodyk.data.repository.UserDataRepository;
import com.iuriirodyk.domain.executor.PostExecutionThread;
import com.iuriirodyk.domain.executor.ThreadExecutor;
import com.iuriirodyk.domain.repository.CardRepository;
import com.iuriirodyk.domain.repository.TransactionRepository;
import com.iuriirodyk.domain.repository.UserRepository;
import com.iuriirodyk.materialwallet.app.MaterialWalletApp;
import com.iuriirodyk.materialwallet.executor.UiThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@Module
public class ApplicationModule {

    private final MaterialWalletApp materialWalletApp;

    public ApplicationModule(MaterialWalletApp materialWalletApp) {
        this.materialWalletApp = materialWalletApp;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.materialWalletApp;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }

    @Provides @Singleton
    CardRepository provideCardRepository(CardDataRepository cardDataRepository) {
        return cardDataRepository;
    }

    @Provides @Singleton
    TransactionRepository provideTransactionRepository(TransactionDataRepository transactionDataRepository) {
        return transactionDataRepository;
    }
}
