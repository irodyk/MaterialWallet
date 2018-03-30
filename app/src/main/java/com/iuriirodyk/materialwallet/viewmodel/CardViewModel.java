package com.iuriirodyk.materialwallet.viewmodel;

import android.os.Bundle;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 30.03.2018.
 */

@AutoValue
public abstract class CardViewModel {

    @NonNull public abstract String holder();
    @NonNull public abstract String pan();
    @NonNull public abstract String expiry();
    @NonNull public abstract IssuerViewModel issuer();
    @NonNull public abstract String currency();
    @NonNull public abstract String balanceTotal();
    @NonNull public abstract String balanceAvlble();
    @NonNull public abstract String balanceBlocked();
    @NonNull public abstract String cardImagePath();

    public static CardViewModel create(
            String holder,
            String pan,
            String expiry,
            IssuerViewModel issuer,
            String cardImagePath,
            String balanceTotal,
            String balanceAvlble,
            String balanceBlocked,
            String currency
    ) {
        return new AutoValue_CardViewModel(
                holder,
                pan,
                expiry,
                issuer,
                cardImagePath,
                balanceTotal,
                balanceAvlble,
                balanceBlocked,
                currency
        );
    }

    public Bundle toExtras(){
        Bundle b = new Bundle();
        b.putString("holder", holder());
        b.putString("pan", pan());
        b.putString("expiry", expiry());
        b.putBundle("issuer", issuer().toExtras());
        b.putString("currency", currency());
        b.putString("balanceTotal", balanceTotal());
        b.putString("balanceAvlble", balanceAvlble());
        b.putString("balanceBlocked", balanceBlocked());
        b.putString("cardImagePath", cardImagePath());
        return b;
    }

    public static CardViewModel fromExtras(Bundle b){
        return create(b.getString("holder"), b.getString("pan"), b.getString("expiry"),
                IssuerViewModel.fromExtras(b.getBundle("issuer")), b.getString("cardImagePath"),
                b.getString("balanceTotal"), b.getString("balanceAvlble"),
                b.getString("balanceBlocked"), b.getString("currency"));
    }
}
