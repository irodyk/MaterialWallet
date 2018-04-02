package com.iuriirodyk.materialwallet.ui.fragment;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.ui.activity.CardDetailsActivity_;
import com.iuriirodyk.materialwallet.ui.activity.HomeActivity;
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
        ((HomeActivity)getActivity()).getCardComponent().inject(this);
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        Intent intent = new Intent(getActivity(), CardDetailsActivity_.class);
        intent.putExtras(card.toExtras());
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    @Override
    public void onDestroyView() {
        ivCard.setImageBitmap(null);
        super.onDestroyView();
    }
}
