package com.iuriirodyk.materialwallet.ui.activity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.transition.Fade;
import android.view.Window;
import android.widget.RelativeLayout;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.di.component.ApplicationComponent;
import com.iuriirodyk.materialwallet.di.component.DaggerTransactionComponent;
import com.iuriirodyk.materialwallet.di.component.TransactionComponent;
import com.iuriirodyk.materialwallet.ui.adapter.CardDetailsPagerAdapter;
import com.iuriirodyk.materialwallet.ui.widget.VerticalViewPager;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 01.04.2018.
 */

@EActivity(R.layout.activity_card_details)
public class CardDetailsActivity extends BaseActivity {

    private TransactionComponent transactionComponent;

    @ViewById(R.id.card_details_root_layout)
    RelativeLayout rootView;

    @ViewById(R.id.viewpager_card_details)
    VerticalViewPager pager;

    private final int[] COLORS = {
            0xFF2F5BA2,
            0xFF5F9CD5
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setExitTransition(new Fade());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Drawable background = rootView.getBackground();
        int color = COLORS[0];
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();
        savedInstanceState.putInt("bg_color", color);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int color = savedInstanceState.getInt("bg_color");
        if(color != 0){
            rootView.setBackgroundColor(color);
        }
    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {
        this.transactionComponent = DaggerTransactionComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @AfterViews
    void initViews() {
        CardDetailsPagerAdapter adapter = new CardDetailsPagerAdapter(getSupportFragmentManager());

        CardViewModel card = CardViewModel.fromExtras(getIntent().getExtras());
        adapter.setCard(card);
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int pos) {
                Drawable background = rootView.getBackground();
                int color = pos;
                if (background instanceof ColorDrawable)
                    color = ((ColorDrawable) background).getColor();

                ValueAnimator colorAnimation = ValueAnimator.ofObject(
                        new ArgbEvaluator(),
                        color,
                        COLORS[pos]);
                colorAnimation.setDuration(1000);
                colorAnimation.addUpdateListener(animator ->
                        rootView.setBackgroundColor((int) animator.getAnimatedValue()));
                colorAnimation.start();
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    public TransactionComponent getTransactionComponent() {
        return transactionComponent;
    }
}