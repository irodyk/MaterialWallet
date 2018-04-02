package com.iuriirodyk.materialwallet.view;

import com.iuriirodyk.materialwallet.viewmodel.TransactionViewModel;

import java.util.List;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 01.04.2018.
 */

public interface TransactionsView {

    /**
     * A method transaction associated views.
     * @param transactions - actual list of transactions for specific card.
     */
    void renderTransactions(List<TransactionViewModel> transactions);

    /**
     * Notify the Ui about error occured.
     * @param msg - error message.
     */
    void onError(String msg);
}
