package com.iuriirodyk.data.repository;

import com.iuriirodyk.data.entity.mapper.CardEntityDataMapper;
import com.iuriirodyk.data.entity.mapper.UserEntityDataMapper;
import com.iuriirodyk.data.repository.datasource.CardDataStore;
import com.iuriirodyk.data.repository.datasource.CommonDataStoreFactory;
import com.iuriirodyk.data.repository.datasource.UserDataStore;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.domain.repository.CardRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

public class CardDataRepository implements CardRepository {

    @Inject CommonDataStoreFactory commonDataStoreFactory;
    @Inject CardEntityDataMapper mapper;

    @Inject CardDataRepository(){
    }

    @Override
    public Observable<List<Card>> cards() {
        CardDataStore cardDataStore = commonDataStoreFactory.createCardDataStore();
        return cardDataStore.cardEntities().map(mapper::cardListFromEntity);
    }
}
