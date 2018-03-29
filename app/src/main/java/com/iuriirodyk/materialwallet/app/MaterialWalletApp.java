package com.iuriirodyk.materialwallet.app;

import android.app.Application;

import com.iuriirodyk.materialwallet.BuildConfig;
import com.iuriirodyk.materialwallet.di.component.ApplicationComponent;
import com.iuriirodyk.materialwallet.di.component.DaggerApplicationComponent;
import com.iuriirodyk.materialwallet.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class MaterialWalletApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();
        initializeLeakDetection();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
