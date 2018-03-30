package com.iuriirodyk.materialwallet.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iuriirodyk.materialwallet.ui.fragment.CardViewFragment;
import com.iuriirodyk.materialwallet.ui.fragment.CardViewFragment_;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;

import java.util.List;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

public class CardPagerAdapter extends FragmentPagerAdapter {

    private List<CardViewModel> cards;

    public CardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setItems(List<CardViewModel> cards){
        this.cards = cards;
    }

    @Override
    public Fragment getItem(int pos) {
        CardViewFragment cardViewFragment = new CardViewFragment_();
        cardViewFragment.setArguments(cards.get(pos).toExtras());
        return cardViewFragment;
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}
