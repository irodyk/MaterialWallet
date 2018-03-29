package com.iuriirodyk.data.entity;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 28.03.2018.
 */

@AutoValue
public abstract class TransactionEntity {

    @NonNull public abstract String transId();
    @NonNull public abstract String type();
    @NonNull public abstract String merchant();
    @NonNull public abstract String amount();
    @NonNull public abstract String currency();
    @NonNull public abstract String balanceAfter();
    @NonNull public abstract String date();
    @NonNull public abstract CardEntity card();

    public static TransactionEntity create(
            String transId,
            String type,
            String merchant,
            String amount,
            String currency,
            String balanceAfter,
            String date,
            CardEntity cardEntity
    ) {
        return new AutoValue_TransactionEntity(
                transId,
                type,
                merchant,
                amount,
                currency,
                balanceAfter,
                date,
                cardEntity
        );
    }
}
