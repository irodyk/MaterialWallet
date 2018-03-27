package com.iuriirodyk.domain.model;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

@AutoValue
public abstract class Card {

    @NonNull public abstract String holder();
    @NonNull public abstract String pan();
    @NonNull public abstract String expiry();
    @NonNull public abstract Issuer issuer();
    @NonNull public abstract String balanceTotal();
    @NonNull public abstract String balanceAvlble();
    @NonNull public abstract String balanceBlocked();
    @NonNull public abstract String cardImagePath();

    public static Card create(
            String holder,
            String pan,
            String expiry,
            Issuer issuer,
            String cardImagePath,
            String balanceTotal,
            String balanceAvlble,
            String balanceBlocked
    ) {
        return new AutoValue_Card(
                holder,
                pan,
                expiry,
                issuer,
                cardImagePath,
                balanceTotal,
                balanceAvlble,
                balanceBlocked
        );
    }
}
