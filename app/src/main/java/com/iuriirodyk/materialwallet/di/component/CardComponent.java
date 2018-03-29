package com.iuriirodyk.materialwallet.di.component;

import com.iuriirodyk.materialwallet.di.module.ActivityModule;
import com.iuriirodyk.materialwallet.di.module.CardModule;
import com.iuriirodyk.materialwallet.di.scope.PerActivity;

import dagger.Component;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, CardModule.class})
public interface CardComponent extends ActivityComponent {

    //fragment to inject
}
