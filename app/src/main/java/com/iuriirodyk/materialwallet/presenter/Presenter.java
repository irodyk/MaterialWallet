package com.iuriirodyk.materialwallet.presenter;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

public interface Presenter<V> {

    /**
     * Ui to set the view for backward communication.
     * @param view - implementation of a specific view.
     */
    void setView(V view);

    /**
     * Ui to notify observables to be disposed.
     */
    void dispose();
}
