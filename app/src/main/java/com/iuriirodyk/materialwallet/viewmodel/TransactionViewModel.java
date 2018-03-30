package com.iuriirodyk.materialwallet.viewmodel;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

@AutoValue
public abstract class TransactionViewModel {

    public enum Type {
        INCOMING("Incoming"),
        OUTGOING("Outgoing");

        String type;

        Type(String type) {
            this.type = type;
        }

        String type(){
            return type;
        }
    }

    @NonNull public abstract String transId();
    @NonNull public abstract Type type();
    @NonNull public abstract String merchant();
    @NonNull public abstract String amount();
    @NonNull public abstract String currency();
    @NonNull public abstract String balanceAfter();
    @NonNull public abstract String date();
    @NonNull public abstract CardViewModel card();

    public static TransactionViewModel create(
            String transId,
            Type type,
            String merchant,
            String amount,
            String currency,
            String balanceAfter,
            String date,
            CardViewModel card
    ) {
        return new AutoValue_TransactionViewModel(
                transId,
                type,
                merchant,
                amount,
                currency,
                balanceAfter,
                date,
                card
        );
    }
}
