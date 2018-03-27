package com.iuriirodyk.domain.model;

import com.google.auto.value.AutoValue;

import io.reactivex.annotations.NonNull;

/**
 * MaterialWallet
 * Created by Iurii Rodyk on 27.03.2018.
 */

@AutoValue
public abstract class Issuer {

    @NonNull public abstract String issuerName();
    @NonNull public abstract String logoImagePath();

    public static Issuer create(String issuerName, String logoImagePath) {
        return new AutoValue_Issuer(issuerName, logoImagePath);
    }
}
