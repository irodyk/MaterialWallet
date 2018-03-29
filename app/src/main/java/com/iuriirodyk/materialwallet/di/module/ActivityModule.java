package com.iuriirodyk.materialwallet.di.module;

import android.app.Activity;

import com.iuriirodyk.materialwallet.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity
    Activity activity() {
        return this.activity;
    }
}
