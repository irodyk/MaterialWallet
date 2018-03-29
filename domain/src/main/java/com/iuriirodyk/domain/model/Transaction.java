package com.iuriirodyk.domain.model;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

@AutoValue
public abstract class Transaction {

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
    @NonNull public abstract Card card();

    public static Transaction create(
            String transId,
            Type type,
            String merchant,
            String amount,
            String currency,
            String balanceAfter,
            String date,
            Card card
    ) {
        return new AutoValue_Transaction(
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
