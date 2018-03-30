package com.iuriirodyk.materialwallet.viewmodel.mapper;

import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.Issuer;
import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;
import com.iuriirodyk.materialwallet.viewmodel.IssuerViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class CardViewModelMapper implements Mapper<CardViewModel, Card> {

    @Inject CardViewModelMapper(){
    }

    @Override
    public Card mapFromViewModel(CardViewModel e) {
        Issuer issuer = Issuer.create(e.issuer().issuerName(), e.issuer().logoImagePath());
        return Card.create(e.holder(), e.pan(), e.expiry(), issuer, e.cardImagePath(), e.balanceTotal(),
                e.balanceAvlble(), e.balanceBlocked(), e.currency());
    }

    @Override
    public CardViewModel mapToViewModel(Card e) {
        IssuerViewModel issuerViewModel = IssuerViewModel.create(e.issuer().issuerName(), e.issuer().logoImagePath());
        return CardViewModel.create(e.holder(), e.pan(), e.expiry(), issuerViewModel, e.cardImagePath(), e.balanceTotal(),
                e.balanceAvlble(), e.balanceBlocked(), e.currency());
    }

    public List<CardViewModel> cardListToViewModel(List<Card> entities){
        List<CardViewModel> cardList = new ArrayList<>();
        for(Card e : entities){
            cardList.add(mapToViewModel(e));
        }
        return cardList;
    }
}
