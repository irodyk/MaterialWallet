package com.iuriirodyk.materialwallet.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iuriirodyk.materialwallet.ui.fragment.BaseFragment;
import com.iuriirodyk.materialwallet.ui.fragment.CardDetailsFragment_;
import com.iuriirodyk.materialwallet.ui.fragment.TransactionsFragment_;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 01.04.2018.
 */

public class CardDetailsPagerAdapter extends FragmentPagerAdapter {

    private CardViewModel card;

    public CardDetailsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setCard(CardViewModel card){
        this.card = card;
    }

    @Override
    public Fragment getItem(int pos) {
        BaseFragment fragment;
        switch (pos){
            case 0:
                fragment = new CardDetailsFragment_();
                break;
            case 1:
                fragment = new TransactionsFragment_();
                break;
                default:
                    throw new IllegalArgumentException("No such page in ViewPager is found!");
        }
        fragment.setArguments(card.toExtras());
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
