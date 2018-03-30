package com.iuriirodyk.materialwallet.presenter;

import com.iuriirodyk.domain.interactor.GetCards;
import com.iuriirodyk.domain.interactor.GetUser;
import com.iuriirodyk.domain.interactor.abs.UseCaseObserver;
import com.iuriirodyk.domain.model.Card;
import com.iuriirodyk.domain.model.User;
import com.iuriirodyk.materialwallet.view.HomeView;
import com.iuriirodyk.materialwallet.viewmodel.mapper.CardViewModelMapper;
import com.iuriirodyk.materialwallet.viewmodel.mapper.UserViewModelMapper;

import java.util.List;

import javax.inject.Inject;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

public class HomePresenter implements Presenter<HomeView> {

    @Inject GetUser getUser;
    @Inject GetCards getCards;

    @Inject UserViewModelMapper userViewModelMapper;
    @Inject CardViewModelMapper cardViewModelMapper;

    private HomeView view;

    private GetUserObserver getUserObserver;
    private GetCardsObserver getCardsObserver;

    @Inject HomePresenter(){
        getUserObserver = new GetUserObserver();
        getCardsObserver = new GetCardsObserver();
    }

    public void getCurrentUser(){
        getUser.execute(getUserObserver, null);
    }

    public void getEnrolledCards(){
        getCards.execute(getCardsObserver, null);
    }

    @Override
    public void setView(HomeView view) {
        this.view = view;
    }

    @Override
    public void dispose() {
        getUserObserver.dispose();
        getCardsObserver.dispose();
    }

    private final class GetUserObserver extends UseCaseObserver<User> {
        @Override
        public void onNext(User user) {
            view.renderUser(userViewModelMapper.mapToViewModel(user));
        }

        @Override
        public void onError(Throwable e) {
            view.onError(e.getMessage());
        }
    }

    private final class GetCardsObserver extends UseCaseObserver<List<Card>> {

        @Override
        public void onNext(List<Card> cards) {
            view.renderCards(cardViewModelMapper.cardListToViewModel(cards));
        }

        @Override
        public void onError(Throwable e) {
            view.onError(e.getMessage());
        }
    }
}
