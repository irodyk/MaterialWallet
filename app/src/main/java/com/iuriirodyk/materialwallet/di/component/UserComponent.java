package com.iuriirodyk.materialwallet.di.component;

import com.iuriirodyk.materialwallet.di.module.ActivityModule;
import com.iuriirodyk.materialwallet.di.module.UserModule;
import com.iuriirodyk.materialwallet.di.scope.PerActivity;
import com.iuriirodyk.materialwallet.ui.activity.BaseActivity;
import com.iuriirodyk.materialwallet.ui.activity.MainActivity;

import dagger.Component;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {

    void inject(MainActivity activity);
}
