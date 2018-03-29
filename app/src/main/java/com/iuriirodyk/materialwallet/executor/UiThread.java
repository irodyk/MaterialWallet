package com.iuriirodyk.materialwallet.executor;

import com.iuriirodyk.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@Singleton
public class UiThread implements PostExecutionThread {

    @Inject UiThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
