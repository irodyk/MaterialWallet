package com.iuriirodyk.materialwallet.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.iuriirodyk.materialwallet.app.MaterialWalletApp;
import com.iuriirodyk.materialwallet.di.component.ApplicationComponent;
import com.iuriirodyk.materialwallet.di.module.ActivityModule;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.WindowFeature;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@EActivity
@Fullscreen
@WindowFeature(Window.FEATURE_NO_TITLE)
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initializeInjector(getApplicationComponent());

        super.onCreate(savedInstanceState);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MaterialWalletApp) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract void initializeInjector(ApplicationComponent applicationComponent);
}
