package com.iuriirodyk.materialwallet.di.component;

import com.iuriirodyk.materialwallet.di.module.ActivityModule;
import com.iuriirodyk.materialwallet.di.module.TransactionModule;
import com.iuriirodyk.materialwallet.di.scope.PerActivity;
import com.iuriirodyk.materialwallet.ui.activity.CardDetailsActivity;
import com.iuriirodyk.materialwallet.ui.fragment.TransactionsFragment;

import dagger.Component;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, TransactionModule.class})
public interface TransactionComponent extends ActivityComponent {

    void inject(TransactionsFragment transactionsFragment);
}
