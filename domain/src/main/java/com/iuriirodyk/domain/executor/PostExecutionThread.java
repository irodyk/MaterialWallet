package com.iuriirodyk.domain.executor;

import io.reactivex.Scheduler;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

public interface PostExecutionThread {

    Scheduler getScheduler();
}
