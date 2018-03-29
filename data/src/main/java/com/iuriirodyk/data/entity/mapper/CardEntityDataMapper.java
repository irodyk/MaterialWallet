package com.iuriirodyk.data.entity.mapper;

import com.iuriirodyk.data.entity.CardEntity;
import com.iuriirodyk.domain.model.Card;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class CardEntityDataMapper implements Mapper<CardEntity, Card> {

    @Inject CardEntityDataMapper(){
    }

    @Override
    public Card mapFromEntity(CardEntity e) {
        return Card.create(e.holder(), e.pan(), e.expiry(), e.issuer(), e.cardImagePath(), e.balanceTotal(),
                            e.balanceAvlble(), e.balanceBlocked());
    }

    @Override
    public CardEntity mapToEntity(Card e) {
        return CardEntity.create(e.holder(), e.pan(), e.expiry(), e.issuer(), e.cardImagePath(), e.balanceTotal(),
                e.balanceAvlble(), e.balanceBlocked());
    }

    public List<Card> cardListFromEntity(List<CardEntity> entities){
        List<Card> cardList = new ArrayList<>();
        for(CardEntity e : entities){
            cardList.add(mapFromEntity(e));
        }
        return cardList;
    }
}
