package com.iuriirodyk.materialwallet.ui.activity;

import android.os.Bundle;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.di.component.ApplicationComponent;
import com.iuriirodyk.materialwallet.di.component.DaggerUserComponent;
import com.iuriirodyk.materialwallet.di.component.UserComponent;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getUserComponent().inject(this);
    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
