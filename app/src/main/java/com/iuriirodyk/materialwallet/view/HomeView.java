package com.iuriirodyk.materialwallet.view;

import com.iuriirodyk.materialwallet.viewmodel.CardViewModel;
import com.iuriirodyk.materialwallet.viewmodel.UserViewModel;

import java.util.List;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

public interface HomeView {

    /**
     * A method to render user associated views.
     * @param user - actual returned user.
     */
    void renderUser(UserViewModel user);

    /**
     * A method to render cards associated views.
     * @param cards - actual list of cards enrolled by user.
     */
    void renderCards(List<CardViewModel> cards);

    /**
     * Notify the Ui about error occured.
     * @param msg - error message.
     */
    void onError(String msg);
}
