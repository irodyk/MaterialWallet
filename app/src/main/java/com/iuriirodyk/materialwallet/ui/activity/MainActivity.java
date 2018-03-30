package com.iuriirodyk.materialwallet.ui.activity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iuriirodyk.domain.interactor.GetCards;
import com.iuriirodyk.domain.interactor.GetUser;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.di.component.ApplicationComponent;
import com.iuriirodyk.materialwallet.di.component.CardComponent;
import com.iuriirodyk.materialwallet.di.component.DaggerCardComponent;
import com.iuriirodyk.materialwallet.di.component.DaggerTransactionComponent;
import com.iuriirodyk.materialwallet.di.component.DaggerUserComponent;
import com.iuriirodyk.materialwallet.di.component.TransactionComponent;
import com.iuriirodyk.materialwallet.di.component.UserComponent;
import com.iuriirodyk.materialwallet.ui.adapter.CardPagerAdapter;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;
import com.iuriirodyk.materialwallet.viewmodel.UserViewModel;
import com.iuriirodyk.materialwallet.viewmodel.mapper.CardViewModelMapper;
import com.iuriirodyk.materialwallet.viewmodel.mapper.UserViewModelMapper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private UserComponent userComponent;
    private CardComponent cardComponent;
    private TransactionComponent transactionComponent;

    private UserViewModel user;

    @ViewById(R.id.root_layout)
    RelativeLayout rootView;

    @Inject GetUser getUser;
    @Inject GetCards getCards;

    @Inject UserViewModelMapper userViewModelMapper;
    @Inject CardViewModelMapper cardViewModelMapper;


    @ViewById(R.id.iv_user_photo)
    ImageView ivUserPhoto;

    @ViewById(R.id.tv_financial_health_status)
    TextView tvFinancialHealthStatus;

    @ViewById(R.id.tv_date)
    TextView tvDate;

    @ViewById(R.id.tv_user_greeting)
    TextView tvUserGreeting;

    @ViewById(R.id.viewpager_cards)
    ViewPager vpCards;

    @ViewById(R.id.tab_dots)
    TabLayout tabLayoutDots;

    private final int[] COLORS = {
            0xFF2F5BA2,
            0xFF8A1448,
            0xFFBE5225
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getUserComponent().inject(this);

        executeCases();
    }

    void executeCases(){
        getUser.execute(new DisposableObserver<User>() {
            @Override
            public void onNext(User user) {
                MainActivity.this.user = userViewModelMapper.mapToViewModel(user);
            }
            @Override
            public void onError(Throwable e) {}
            @Override
            public void onComplete() {
                String greeting = "Hello, " + user.name() + "!";
                tvUserGreeting.setText(greeting);
                loadUserImage();
            }
        }, null);

        getCards.execute(new DisposableObserver<List<Card>>() {
            @Override
            public void onNext(List<Card> cards) {
                List<CardViewModel> cardViewModels = cardViewModelMapper.cardListToViewModel(cards);

                initCardViewPager(cardViewModels);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, null);
    }

    @AfterViews
    void initViews() {
        tabLayoutDots.setupWithViewPager(vpCards);

        tvFinancialHealthStatus.setText(R.string.financial_health_status);
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH);
        String dateText = "Today: " + formatter.format(date);
        tvDate.setText(dateText);
    }

    @Background
    void loadUserImage(){
        try {
            InputStream is = getAssets().open(user.photoPath());
            Bitmap bmp = BitmapFactory.decodeStream(is);
            setUserPhoto(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void setUserPhoto(Bitmap photo){
        ivUserPhoto.setImageBitmap(photo);
    }

    private void initCardViewPager(List<CardViewModel> cardViewModels){
        CardPagerAdapter adapter = new CardPagerAdapter(getSupportFragmentManager());
        adapter.setItems(cardViewModels);
        vpCards.setAdapter(adapter);

        tabLayoutDots.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();

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
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Click(R.id.iv_user_photo)
    public void onUserImageClick(View v){
        Toast.makeText(this, "Boom!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.cardComponent = DaggerCardComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.transactionComponent = DaggerTransactionComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public CardComponent getCardComponent() {
        return cardComponent;
    }

    public TransactionComponent getTransactionComponent() {
        return transactionComponent;
    }
}
