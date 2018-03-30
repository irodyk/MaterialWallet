package com.iuriirodyk.materialwallet.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.ui.activity.MainActivity;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.io.InputStream;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

@EFragment(R.layout.fragment_cardview)
public class CardViewFragment extends BaseFragment {

    @ViewById(R.id.iv_card)
    ImageView ivCard;

    private CardViewModel card;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity)getActivity()).getCardComponent().inject(this);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @AfterViews
    void showCard(){
        card = CardViewModel.fromExtras(getArguments());
        loadCardImage();
    }

    @Background
    void loadCardImage(){
        try {
            InputStream is = getActivity().getAssets().open(card.cardImagePath());
            Bitmap bmp = BitmapFactory.decodeStream(is);
            setCardPhoto(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void setCardPhoto(Bitmap photo){
        ivCard.setImageBitmap(photo);
    }

    @Click(R.id.iv_card)
    void cardClick(){

    }
}
