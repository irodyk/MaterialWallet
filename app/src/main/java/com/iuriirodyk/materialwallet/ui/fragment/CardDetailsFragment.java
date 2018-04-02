package com.iuriirodyk.materialwallet.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import com.iuriirodyk.materialwallet.R;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.io.InputStream;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 01.04.2018.
 */

@EFragment(R.layout.fragment_card_details)
public class CardDetailsFragment extends BaseFragment {

    @ViewById(R.id.iv_card)
    ImageView ivCard;

    @ViewById(R.id.tv_pan)
    TextView tvPan;

    @ViewById(R.id.tv_expiry)
    TextView tvExpiry;

    @ViewById(R.id.tv_balance)
    TextView tvBalance;

    @AfterViews
    void init(){
        CardViewModel card = CardViewModel.fromExtras(getArguments());

        String starredPan = card.pan();
        for(int i = 4; i < starredPan.length()-4; i++){
            starredPan = starredPan.substring(0, i) + "*" + starredPan.substring(i+1);
        }

        tvPan.setText(starredPan);
        tvExpiry.setText(card.expiry());

        String balanceText = card.balanceAvlble() + " " + card.currency();
        tvBalance.setText(balanceText);

        loadCardImage(card.cardImagePath());
    }

    @Background
    void loadCardImage(String path){
        try {
            InputStream is = getActivity().getAssets().open(path);
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

    @Override
    public void onDestroyView() {
        ivCard.setImageBitmap(null);
        super.onDestroyView();
    }
}
